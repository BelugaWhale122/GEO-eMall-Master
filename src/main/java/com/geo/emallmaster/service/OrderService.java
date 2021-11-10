package com.geo.emallmaster.service;

import com.geo.emallmaster.controller.vo.ShoppingCartItemVO;
import com.geo.emallmaster.controller.vo.UserVO;
import com.geo.emallmaster.utils.PageQueryUtil;
import com.geo.emallmaster.utils.PageResult;

import java.util.List;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/11/08 8:56
 */
public interface OrderService {

    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult OrderPage(PageQueryUtil pageUtil);

    /**
     * 保存订单
     *
     * @param user
     * @param myShoppingCartItems
     * @return
     */
    String saveOrder(UserVO user, List<ShoppingCartItemVO> myShoppingCartItems);
}
