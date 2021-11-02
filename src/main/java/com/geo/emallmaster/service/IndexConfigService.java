package com.geo.emallmaster.service;

import com.geo.emallmaster.controller.vo.IndexGoodsConfigVO;
import com.geo.emallmaster.entity.IndexConfig;
import com.geo.emallmaster.utils.PageQueryUtil;
import com.geo.emallmaster.utils.PageResult;

import java.util.List;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/11/02 19:48
 */
public interface IndexConfigService {
    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getConfigsPage(PageQueryUtil pageUtil);

    /**
     * 添加
     * @param indexConfig
     * @return
     */
    String saveIndexConfig(IndexConfig indexConfig);

    /**
     * 修改
     * @param indexConfig
     * @return
     */
    String updateIndexConfig(IndexConfig indexConfig);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    Boolean deleteBatch(Long[] ids);

    /**
     * 查找
     * @param id
     * @return
     */
    IndexConfig getIndexConfigById(Long id);

    /**
     * 返回固定数量的首页配置商品对象(首页调用)
     * @param configType
     * @param number
     * @return
     */
    List<IndexGoodsConfigVO> getConfigGoodsForIndex(int configType, int number);
}

