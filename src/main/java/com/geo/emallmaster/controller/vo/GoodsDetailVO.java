package com.geo.emallmaster.controller.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/11/02 23:23
 * 商品详情页VO
 */
@Setter
@Getter
public class GoodsDetailVO implements Serializable {
    private Long goodsId;
    private String goodsName;
    private String goodsIntro;
    private String goodsCoverImg;
    private String[] goodsCarouselList;
    private Integer sellingPrice;
    private Integer originalPrice;
    private String goodsDetailContent;
}
