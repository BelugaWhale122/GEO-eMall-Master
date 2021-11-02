package com.geo.emallmaster.controller.mall;

import com.geo.emallmaster.common.Constants;
import com.geo.emallmaster.common.IndexConfigTypeEnum;
import com.geo.emallmaster.controller.vo.IndexCarouselVO;
import com.geo.emallmaster.controller.vo.IndexCategoryVO;
import com.geo.emallmaster.controller.vo.IndexGoodsConfigVO;
import com.geo.emallmaster.service.CarouselService;
import com.geo.emallmaster.service.GoodsCategoryService;
import com.geo.emallmaster.service.IndexConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/11/02 14:51
 */
@Controller
public class IndexController {

    @Resource
    private GoodsCategoryService goodsCategoryService;
    @Resource
    private CarouselService carouselService;
    @Resource
    private IndexConfigService indexConfigService;

    @GetMapping({"/index", "/", "/index.html"})
    public String indexPage(HttpServletRequest request) {
        List<IndexCategoryVO> categories = goodsCategoryService.getCategoriesForIndex();
        List<IndexCarouselVO> carousels = carouselService.getCarouselForIndex(Constants.INDEX_CAROUSEL_NUMBER);
        List<IndexGoodsConfigVO> hotGoods = indexConfigService.getConfigGoodsForIndex(IndexConfigTypeEnum.INDEX_GOODS_HOT.getType(), Constants.INDEX_GOODS_HOT_NUMBER);
        List<IndexGoodsConfigVO> newGoods = indexConfigService.getConfigGoodsForIndex(IndexConfigTypeEnum.INDEX_GOODS_NEW.getType(), Constants.INDEX_GOODS_NEW_NUMBER);
        List<IndexGoodsConfigVO> recommendGoods = indexConfigService.getConfigGoodsForIndex(IndexConfigTypeEnum.INDEX_GOODS_RECOMMOND.getType(), Constants.INDEX_GOODS_RECOMMOND_NUMBER);

        request.setAttribute("categories", categories);//分类数据
        request.setAttribute("carousels", carousels);//轮播图
        request.setAttribute("hotGoodses", hotGoods);//热销商品
        request.setAttribute("newGoodses", newGoods);//新品
        request.setAttribute("recommendGoodses", recommendGoods);//推荐商品
        return "mall/index";
    }
}
