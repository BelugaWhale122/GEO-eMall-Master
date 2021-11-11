package com.geo.emallmaster.controller.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/11/08 9:31
 */
@Setter
@Getter
public class OrderListVO implements Serializable {
    private Long orderId;

    private String orderNo;

    private Integer totalPrice;

    private Byte payType;

    private Byte orderStatus;

    private String orderStatusString;

    private String userAddress;

    private Date createTime;

    private List<OrderItemVO> orderItemVOS;
}
