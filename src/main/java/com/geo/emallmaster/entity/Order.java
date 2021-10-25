package com.geo.emallmaster.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/10/14
 */


@Table(name = "`order`", indexes = {
        @Index(name = "mall_order_order_no_uindex", columnList = "order_no", unique = true)
})
@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @Column(name = "order_no", nullable = false, length = 20)
    private String orderNo;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "total_price", nullable = false)
    private Integer totalPrice;

    @Column(name = "pay_status", nullable = false)
    private Integer payStatus;

    @Column(name = "pay_type", nullable = false)
    private Integer payType;

    @Column(name = "pay_time")
    private Instant payTime;

    @Column(name = "order_status", nullable = false)
    private Integer orderStatus;

    @Column(name = "extra_info", nullable = false, length = 100)
    private String extraInfo;

    @Column(name = "user_name", nullable = false, length = 30)
    private String userName;

    @Column(name = "user_phone", nullable = false, length = 11)
    private String userPhone;

    @Column(name = "user_address", nullable = false, length = 100)
    private String userAddress;

    @Column(name = "is_deleted", nullable = false)
    private Integer isDeleted;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "update_time", nullable = false)
    private Date updateTime;

}