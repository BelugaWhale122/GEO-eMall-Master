package com.geo.emallmaster.service.impl;

import com.geo.emallmaster.common.Constants;
import com.geo.emallmaster.common.ServiceResultEnum;
import com.geo.emallmaster.controller.common.MallException;
import com.geo.emallmaster.controller.vo.ShoppingCartItemVO;
import com.geo.emallmaster.controller.vo.UserVO;
import com.geo.emallmaster.dao.GoodsMapper;
import com.geo.emallmaster.dao.OrderItemMapper;
import com.geo.emallmaster.dao.OrderMapper;
import com.geo.emallmaster.dao.ShoppingCartItemMapper;
import com.geo.emallmaster.entity.Goods;
import com.geo.emallmaster.entity.Order;
import com.geo.emallmaster.entity.OrderItem;
import com.geo.emallmaster.entity.StockNumDTO;
import com.geo.emallmaster.service.OrderService;
import com.geo.emallmaster.utils.BeanUtil;
import com.geo.emallmaster.utils.NumberUtil;
import com.geo.emallmaster.utils.PageQueryUtil;
import com.geo.emallmaster.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/11/08 9:00
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private ShoppingCartItemMapper shoppingCartItemMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public PageResult OrderPage(PageQueryUtil pageUtil) {
        List<Order> orders = orderMapper.findOrderList(pageUtil);
        int total = orderMapper.getTotalOrders(pageUtil);
        PageResult pageResult = new PageResult(total, pageUtil.getLimit(), pageUtil.getPage(), orders);
        return pageResult;
    }

    @Override
    @Transactional
    public String saveOrder(UserVO user, List<ShoppingCartItemVO> myShoppingCartItems) {
        List<Long> itemIdList = myShoppingCartItems.stream().map(ShoppingCartItemVO::getCartItemId).collect(Collectors.toList());
        List<Long> goodsIds = myShoppingCartItems.stream().map(ShoppingCartItemVO::getGoodsId).collect(Collectors.toList());
        List<Goods> goods = goodsMapper.selectByPrimaryKeys(goodsIds);
        //检查是否包含已下架商品
        List<Goods> goodsListNotSelling = goods.stream()
                .filter(GoodsTemp -> GoodsTemp.getGoodsSellStatus() != Constants.SELL_STATUS_UP)
                .collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(goodsListNotSelling)) {
            //goodsListNotSelling 对象非空则表示有下架商品
            MallException.fail(goodsListNotSelling.get(0).getGoodsName() + "已下架，无法生成订单");
        }
        Map<Long, Goods> GoodsMap = goods.stream().collect(Collectors.toMap(Goods::getGoodsId, Function.identity(), (entity1, entity2) -> entity1));
        //判断商品库存
        for (ShoppingCartItemVO shoppingCartItemVO : myShoppingCartItems) {
            //查出的商品中不存在购物车中的这条关联商品数据，直接返回错误提醒
            if (!GoodsMap.containsKey(shoppingCartItemVO.getGoodsId())) {
                MallException.fail(ServiceResultEnum.SHOPPING_ITEM_ERROR.getResult());
            }
            //存在数量大于库存的情况，直接返回错误提醒
            if (shoppingCartItemVO.getGoodsCount() > GoodsMap.get(shoppingCartItemVO.getGoodsId()).getStockNum()) {
                MallException.fail(ServiceResultEnum.SHOPPING_ITEM_COUNT_ERROR.getResult());
            }
        }
        //删除购物项
        if (!CollectionUtils.isEmpty(itemIdList) && !CollectionUtils.isEmpty(goodsIds) && !CollectionUtils.isEmpty(goods)) {
            if (shoppingCartItemMapper.deleteBatch(itemIdList) > 0) {
                List<StockNumDTO> stockNumDTOS = BeanUtil.copyList(myShoppingCartItems, StockNumDTO.class);
                int updateStockNumResult = goodsMapper.updateStockNum(stockNumDTOS);
                if (updateStockNumResult < 1) {
                    MallException.fail(ServiceResultEnum.SHOPPING_ITEM_COUNT_ERROR.getResult());
                }
                //生成订单号
                String orderNo = NumberUtil.genOrderNo();
                int priceTotal = 0;
                //保存订单
                Order order = new Order();
                order.setOrderNo(orderNo);
                order.setUserId(user.getUserId());
                order.setUserAddress(user.getAddress());
                //总价
                for (ShoppingCartItemVO ShoppingCartItemVO : myShoppingCartItems) {
                    priceTotal += ShoppingCartItemVO.getGoodsCount() * ShoppingCartItemVO.getSellingPrice();
                }
                if (priceTotal < 1) {
                    MallException.fail(ServiceResultEnum.ORDER_PRICE_ERROR.getResult());
                }
                order.setTotalPrice(priceTotal);
                //订单body字段，用来作为生成支付单描述信息，暂时未接入第三方支付接口，故该字段暂时设为空字符串
                String extraInfo = "";
                order.setExtraInfo(extraInfo);
                //生成订单项并保存订单项纪录
                if (orderMapper.insertSelective(order) > 0) {
                    //生成所有的订单项快照，并保存至数据库
                    List<OrderItem> orderItems = new ArrayList<>();
                    for (ShoppingCartItemVO ShoppingCartItemVO : myShoppingCartItems) {
                        OrderItem OrderItem = new OrderItem();
                        //使用BeanUtil工具类将ShoppingCartItemVO中的属性复制到OrderItem对象中
                        BeanUtil.copyProperties(ShoppingCartItemVO, OrderItem);
                        //OrderMapper文件insert()方法中使用了useGeneratedKeys因此orderId可以获取到
                        OrderItem.setOrderId(order.getOrderId());
                        orderItems.add(OrderItem);
                    }
                    //保存至数据库
                    if (orderItemMapper.insertBatch(orderItems) > 0) {
                        //所有操作成功后，将订单号返回，以供Controller方法跳转到订单详情
                        return orderNo;
                    }
                    MallException.fail(ServiceResultEnum.ORDER_PRICE_ERROR.getResult());
                }
                MallException.fail(ServiceResultEnum.DB_ERROR.getResult());
            }
            MallException.fail(ServiceResultEnum.DB_ERROR.getResult());
        }
        MallException.fail(ServiceResultEnum.SHOPPING_ITEM_ERROR.getResult());
        return ServiceResultEnum.SHOPPING_ITEM_ERROR.getResult();
    }

}
