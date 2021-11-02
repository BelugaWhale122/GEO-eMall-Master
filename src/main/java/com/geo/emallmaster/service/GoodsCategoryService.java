package com.geo.emallmaster.service;

import com.geo.emallmaster.controller.vo.IndexCategoryVO;
import com.geo.emallmaster.entity.GoodsCategory;
import com.geo.emallmaster.utils.PageQueryUtil;
import com.geo.emallmaster.utils.PageResult;

import java.util.List;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/11/01 17:01
 */
public interface GoodsCategoryService {

    /**
     * 后台分页
     * @param pageUtil
     * @return
     */
    PageResult getCategoryPage(PageQueryUtil pageUtil);

    /**
     * 增加
     * @param goodsCategory
     * @return
     */
    String savaCategory(GoodsCategory goodsCategory);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    Boolean deleteBatch(Integer[] ids);

    /**
     * 修改
     * @param goodsCategory
     * @return
     */
    String updateCategory(GoodsCategory goodsCategory);

    /**
     * 查找
     * @param id
     * @return
     */
    GoodsCategory getGoodsCategoryById(Long id);

    /**
     * 根据parentId和level获取分类列表
     * @param parentIds
     * @param categoryLevel
     * @return
     */
    List<GoodsCategory> selectByLevelAndParentIdsAndNumber(List<Long> parentIds, int categoryLevel);

    /**
     * 返回分类数据(首页调用)
     * @return
     */
    List<IndexCategoryVO> getCategoriesForIndex();
}
