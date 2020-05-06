package com.example.empty.infrastructure.exception;

/**
 * @author created by guanchen on 2020/5/6 11:20
 *
 * 调用第三方服务时发生异常，捕获后 抛出该异常。
 */
public class ThirdPatryException extends RuntimeException {
    public ThirdPatryException(String msg) {
        super(msg);
    }
}
