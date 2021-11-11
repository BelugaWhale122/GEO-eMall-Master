package com.geo.emallmaster.controller.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/11/08 9:29
 * 订单详情页页面VO
 */
@Setter
@Getter
public class OrderDetailVO implements Serializable {
    private String orderNo;

    private Integer totalPrice;

    private Byte payStatus;

    private String payStatusString;

    private Byte payType;

    private String payTypeString;

    private Date payTime;

    private Byte orderStatus;

    private String orderStatusString;

    private String userAddress;

    private Date createTime;

    private List<OrderItemVO> orderItemVOS;
}
