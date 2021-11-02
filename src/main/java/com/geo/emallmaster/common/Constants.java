package com.geo.emallmaster.common;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/11/01 15:58
 */
public class Constants {
    //上传文件的默认url前缀
    public final static String FILE_UPLOAD_DIC = "E:\\temp\\upload\\";

    public final static int SELL_STATUS_UP = 0;//商品上架状态
    public final static int SELL_STATUS_DOWN = 1;//商品下架状态


    public final static int INDEX_CAROUSEL_NUMBER = 5;//首页轮播图数量
    public final static int INDEX_CATEGORY_NUMBER = 10;//首页一级分类的最大数量

    public final static int INDEX_GOODS_HOT_NUMBER = 4;//首页热卖商品数量
    public final static int INDEX_GOODS_NEW_NUMBER = 5;//首页新品数量
    public final static int INDEX_GOODS_RECOMMOND_NUMBER = 10;//首页推荐商品数量

    public final static String USER_SESSION_KEY = "user";//session中user的key
    public final static String MALL_VERIFY_CODE_KEY = "mallVerifyCode";//验证码key

    public final static int GOODS_SEARCH_PAGE_LIMIT = 10;//搜索分页的默认条数(每页10条)
    public final static int SEARCH_CATEGORY_NUMBER = 8;//搜索页一级分类的最大数量

    public final static int SHOPPING_CART_ITEM_TOTAL_NUMBER = 13;//购物车中商品的最大数量

    public final static int SHOPPING_CART_ITEM_LIMIT_NUMBER = 5;//购物车中单个商品的最大购买数量

}
