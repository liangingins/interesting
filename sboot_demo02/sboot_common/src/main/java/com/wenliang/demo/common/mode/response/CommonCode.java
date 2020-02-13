package com.wenliang.demo.common.mode.response;

import lombok.ToString;

@ToString
public enum CommonCode implements ResultCode {
    //操作成功信息
    SUCCESS(true,10000,"操作成功"),
    //操作失败信息
    FAIL(false,20000,"操作失败"),

    SERVER_ERROR(false,99999,"抱歉，系统繁忙，请稍后再试！"),
    ADD_IS_NULL(false,20001,"添加的信息为空"),
    UPDATE_IS_NULL(false,20002,"修改信息不能为空"),
    PARAM_IS_NULL (false,20003,"请求参数不能为空");
    boolean success;

    int code;

    String message;

    CommonCode(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
