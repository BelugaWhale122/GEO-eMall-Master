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

@Table(name = "order_item")
@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id", nullable = false)
    private Long orderItemId;

    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @Column(name = "goods_id", nullable = false)
    private Long goodsId;

    @Column(name = "goods_name", nullable = false, length = 200)
    private String goodsName;

    @Column(name = "goods_cover_img", nullable = false, length = 200)
    private String goodsCoverImg;

    @Column(name = "selling_price", nullable = false)
    private Integer sellingPrice;

    @Column(name = "goods_count", nullable = false)
    private Integer goodsCount;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_time", nullable = false)
    private Date createTime;

}