package com.geo.emallmaster.controller.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 首页分类数据VO
 *
 * @author Xu
 * @version 1.0
 * @date 2021/11/02 15:53
 */
@Setter
@Getter
public class IndexCategoryVO implements Serializable {
    private Long categoryId;
    private Byte categoryLevel;
    private String categoryName;
    private List<SecondLevelCategoryVO> secondLevelCategoryVOS;
}
