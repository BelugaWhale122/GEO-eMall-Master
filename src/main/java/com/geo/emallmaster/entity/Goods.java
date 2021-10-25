package com.geo.emallmaster.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/10/14
 */

@Table(name = "goods_info")
@Entity
@Data
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_id", nullable = false)
    private Long goodsId;

    @Column(name = "goods_name", nullable = false, length = 200)
    private String goodsName;

    @Column(name = "goods_intro", nullable = false, length = 200)
    private String goodsIntro;

    @Column(name = "goods_category_id", nullable = false)
    private Long goodsCategoryId;

    @Column(name = "goods_carousel", nullable = false, length = 200)
    private String goodsCarousel;

    @Lob
    @Column(name = "goods_detail_content", nullable = false)
    private String goodsDetailContent;

    @Column(name = "original_price", nullable = false)
    private Integer originalPrice;

    @Column(name = "selling_price", nullable = false)
    private Integer sellingPrice;

    @Column(name = "stock_num", nullable = false)
    private Integer stockNum;

    @Column(name = "goods_cover_img", nullable = false, length = 200)
    private String goodsCoverImg;

    @Column(name = "goods_sell_status", nullable = false)
    private Integer goodsSellStatus;

    @Column(name = "create_user", nullable = false)
    private Integer createUser;

    @Column(name = "create_time", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @Column(name = "update_user", nullable = false)
    private Integer updateUser;

    @Column(name = "update_time", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @Column(name = "tag", nullable = false, length = 20)
    private String tag;

}