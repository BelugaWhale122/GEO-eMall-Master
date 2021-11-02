package com.geo.emallmaster.controller.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/11/02 19:58
 */
@Setter
@Getter
public class IndexGoodsConfigVO implements Serializable {
    private Long goodsId;
    private String goodsName;
    private String goodsIntro;
    private String goodsCoverImg;
    private Integer sellingPrice;
    private String tag;
}
