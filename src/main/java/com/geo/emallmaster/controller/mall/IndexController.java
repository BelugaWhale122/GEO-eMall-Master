package com.geo.emallmaster.controller.mall;

import com.geo.emallmaster.common.Constants;
import com.geo.emallmaster.controller.vo.IndexCarouselVO;
import com.geo.emallmaster.controller.vo.IndexCategoryVO;
import com.geo.emallmaster.service.CarouselService;
import com.geo.emallmaster.service.GoodsCategoryService;
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

    @GetMapping({"/index", "/", "/index.html"})
    public String indexPage(HttpServletRequest request) {
        List<IndexCategoryVO> categories = goodsCategoryService.getCategoriesForIndex();
        List<IndexCarouselVO> carousels = carouselService.getCarouselForIndex(Constants.INDEX_CAROUSEL_NUMBER);
        request.setAttribute("categories", categories);//分类数据
        request.setAttribute("carousels", carousels);//轮播图
        return "mall/index";
    }
}
