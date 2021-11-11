package com.geo.emallmaster.controller.common;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/11/08 9:05
 */
public class MallException extends RuntimeException {
    public MallException() {
    }

    public MallException(String message) {
        super(message);
    }

    /**
     * 抛出异常
     *
     * @param message
     */
    public static void fail(String message) {
        throw new MallException(message);
    }
}
