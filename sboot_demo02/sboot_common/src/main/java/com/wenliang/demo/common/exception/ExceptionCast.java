package com.wenliang.demo.common.exception;

import com.wenliang.demo.common.mode.response.ResultCode;

/**
 * @description: 异常抛出类
 * @author: cwl
 * @createDate: 2020/1/30
 */
public class ExceptionCast {

    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }

}
