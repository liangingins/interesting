package com.wenliang.demo.entity.user.response;

import com.wenliang.demo.common.mode.response.ResultCode;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/2/1
 */
public enum  UserCode implements ResultCode {

    //用户不存在
    USER_NOT_EXSIT(false,31001,"用户不存在"),
    ADD_IS_NULL(false,31002,"添加的信息为空")
    ;

    boolean success;

    int code;

    String message;

    UserCode(boolean success, int code, String message) {
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
