package com.geo.emallmaster.controller.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/11/02 23:39
 * 购物车页面购物项VO
 */
@Setter
@Getter
public class ShoppingCartItemVO implements Serializable {
    private Long cartItemId;
    private Long goodsId;
    private Integer goodsCount;
    private String goodsName;
    private String goodsCoverImg;
    private Integer sellingPrice;
}
