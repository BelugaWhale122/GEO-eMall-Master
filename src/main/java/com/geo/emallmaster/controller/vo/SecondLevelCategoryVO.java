package com.geo.emallmaster.controller.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 二级分类数据VO
 * @author Xu
 * @version 1.0
 * @date 2021/11/02 16:00
 */
@Setter
@Getter
public class SecondLevelCategoryVO implements Serializable {
    private Long categoryId;
    private Byte categoryLevel;
    private String categoryName;
    private Long parentId;
    private List<ThirdLevelCategoryVO> thirdLevelCategoryVOS;
}
