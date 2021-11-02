package com.geo.emallmaster.controller.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/11/02 21:05
 */
@Setter
@Getter
public class UserVO implements Serializable {
    private Long userId;
    private String nickName;
    private String loginName;
    private String introduceSign;
    private String address;
    private int shopCartItemCount;
}
