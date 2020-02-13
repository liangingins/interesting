package com.wenliang.demo.entity.dishes.response;

import com.wenliang.demo.common.mode.response.ResultCode;

public enum DishesCode implements ResultCode {

     //菜品不存在
     DISHES_NOT_EXIST(false,31001,"菜品不存在");


    boolean success;

    int code;

    String message;

    DishesCode(boolean success, int code, String message) {
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
