package com.geo.emallmaster.controller.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 首页轮播图VO
 * @author Xu
 * @version 1.0
 * @date 2021/11/02 15:53
 */
@Setter
@Getter
public class IndexCarouselVO implements Serializable {
    private String carouselUrl;
    private String redirectUrl;
}
