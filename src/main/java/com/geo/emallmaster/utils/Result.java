package com.geo.emallmaster.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/10/29 20:11
 */
@Setter
@Getter
@ToString
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    //业务码
    private int resultCode;
    //返回信息
    private String message;
    //数据结果
    private T data;

    public Result() {
    }

    public Result(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public Result failure(String code) {
        return new Result(500, "服务错误");
    }

}