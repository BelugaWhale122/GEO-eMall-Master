package com.geo.emallmaster.controller.mall;

import com.geo.emallmaster.common.Constants;
import com.geo.emallmaster.common.ServiceResultEnum;
import com.geo.emallmaster.controller.common.MallException;
import com.geo.emallmaster.controller.vo.ShoppingCartItemVO;
import com.geo.emallmaster.controller.vo.UserVO;
import com.geo.emallmaster.service.OrderService;
import com.geo.emallmaster.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/11/08 8:50
 */
@Controller
public class OrderController {

    @Resource
    private ShoppingCartService shoppingCartService;
    @Resource
    private OrderService orderService;

    @GetMapping("/saveOrder")
    public String saveOrder(HttpSession httpSession) {
        UserVO user = (UserVO) httpSession.getAttribute(Constants.USER_SESSION_KEY);
        List<ShoppingCartItemVO> myShoppingCartItems = shoppingCartService.getMyShoppingCartItems(user.getUserId());
        if (StringUtils.isEmpty(user.getAddress().trim())) {
            //无收货地址
            MallException.fail(ServiceResultEnum.NULL_ADDRESS_ERROR.getResult());
        }
        if (CollectionUtils.isEmpty(myShoppingCartItems)) {
            //购物车中无数据则跳转至错误页
            MallException.fail(ServiceResultEnum.SHOPPING_ITEM_ERROR.getResult());
        }
        //保存订单并返回订单号
        String saveOrderResult = orderService.saveOrder(user, myShoppingCartItems);
        //跳转到订单详情页
        return "redirect:/orders/" + saveOrderResult;
    }
}
