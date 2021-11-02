package com.geo.emallmaster.controller.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 三级分类数据VO
 * @author Xu
 * @version 1.0
 * @date 2021/11/02 16:01
 */
@Setter
@Getter
public class ThirdLevelCategoryVO implements Serializable {
    private Long categoryId;
    private Byte categoryLevel;
    private String categoryName;
    private Long parentId;
}
