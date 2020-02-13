package com.wenliang.demo.common.exception;

import com.wenliang.demo.common.mode.response.ResultCode;

/**
 * @description: 自定义异常类
 * @author: cwl
 * @createDate: 2020/1/30
 */


public class CustomException extends RuntimeException {

    private ResultCode resultCode;



    public  CustomException(ResultCode resultCode){
        super("错误代码: "+resultCode+" 错误信息: "+resultCode.message());
        this.resultCode = resultCode;

    }

    public ResultCode getResultCode( ) {
        return this.resultCode;
    }


}
