package com.geo.emallmaster.service;

import com.geo.emallmaster.controller.vo.IndexCarouselVO;
import com.geo.emallmaster.entity.Carousel;
import com.geo.emallmaster.utils.PageQueryUtil;
import com.geo.emallmaster.utils.PageResult;

import java.util.List;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/11/01 14:41
 */
public interface CarouselService {

    /**
     * 后台分页
     *
     * @param pageUtil
     * @return
     */
    PageResult getCarouselPage(PageQueryUtil pageUtil);

    /**
     * 添加轮播图
     *
     * @param carousel
     * @return
     */
    String saveCarousel(Carousel carousel);

    /**
     * 修改轮播图
     *
     * @param carousel
     * @return
     */
    String updateCarousel(Carousel carousel);

    /**
     * 根据 id 获取单条轮播图记录
     *
     * @param id
     * @return
     */
    Carousel getCarouselById(Integer id);

    /**
     * 批量删除轮播图
     *
     * @param ids
     * @return
     */
    Boolean deleteBatch(Integer[] ids);

    /**
     * 返回轮播图数据(首页调用)
     * @param number
     * @return
     */
    List<IndexCarouselVO> getCarouselForIndex(int number);
}
