package com.geo.emallmaster.controller.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/11/08 9:30
 * 订单详情页页面订单项VO
 */
@Setter
@Getter
public class OrderItemVO implements Serializable {
    private Long goodsId;

    private Integer goodsCount;

    private String goodsName;

    private String goodsCoverImg;

    private Integer sellingPrice;
}
