package com.wenliang.demo.common.mode.response;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/1/29
 */
public interface ResultCode {

    boolean success();

    int code();

    String message();
}
