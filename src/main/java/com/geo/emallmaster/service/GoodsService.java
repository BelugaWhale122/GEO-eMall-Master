package com.geo.emallmaster.service;

import com.geo.emallmaster.entity.Goods;
import com.geo.emallmaster.utils.PageQueryUtil;
import com.geo.emallmaster.utils.PageResult;

import java.util.List;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/11/01 22:01
 */
public interface GoodsService {

    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getGoodsPage(PageQueryUtil pageUtil);

    /**
     * 添加商品
     *
     * @param goods
     * @return
     */
    String saveGoods(Goods goods);

    /**
     * 批量新增商品
     *
     * @param goodsList
     */
    void batchSaveGoods(List<Goods> goodsList);

    /**
     * 修改商品信息
     *
     * @param goods
     * @return
     */
    String updateGoods(Goods goods);

    /**
     * 根据商品id查找商品
     *
     * @param id
     * @return
     */
    Goods getGoodsById(Long id);

    /**
     * 批量修改销售状态
     *
     * @param ids
     * @param sellStatus
     * @return
     */
    Boolean batchUpdateSellStatus(Long[] ids, int sellStatus);

    /**
     * 商品搜索
     *
     * @param pageUtil
     * @return
     */
    PageResult searchGoods(PageQueryUtil pageUtil);
}
