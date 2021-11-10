package com.geo.emallmaster.service;

import com.geo.emallmaster.controller.vo.ShoppingCartItemVO;
import com.geo.emallmaster.entity.ShoppingCartItem;

import java.util.List;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/11/02 23:32
 */
public interface ShoppingCartService {

    /**
     * 添加商品至购物车中
     *
     * @param shoppingCartItem
     * @return
     */
    String saveShoppingCartItem(ShoppingCartItem shoppingCartItem);

    /**
     * 修改购物车中的属性
     *
     * @param shoppingCartItem
     * @return
     */
    String updateShoppingCartItem(ShoppingCartItem shoppingCartItem);

    /**
     * 获取购物项详情
     *
     * @param shoppingCartItemId
     * @return
     */
    ShoppingCartItem getShoppingCartItemById(Long shoppingCartItemId);

    /**
     * 删除购物车中的商品
     *
     * @param shoppingCartItemId
     * @param userId
     * @return
     */
    Boolean deleteById(Long shoppingCartItemId, Long userId);

    /**
     * 获取购物车中的列表数据
     *
     * @param userId
     * @return
     */
    List<ShoppingCartItemVO> getMyShoppingCartItems(Long userId);
}
