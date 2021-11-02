package com.geo.emallmaster.controller.vo;

import com.geo.emallmaster.entity.GoodsCategory;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/11/02 22:19
 */
@Setter
@Getter
public class SearchPageCategoryVO implements Serializable {
    private String firstLevelCategoryName;
    private List<GoodsCategory> secondLevelCategoryList;
    private String secondLevelCategoryName;
    private List<GoodsCategory> thirdLevelCategoryList;
    private String currentCategoryName;
}
