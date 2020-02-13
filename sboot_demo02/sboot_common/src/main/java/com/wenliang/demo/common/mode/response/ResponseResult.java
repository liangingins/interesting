package com.wenliang.demo.common.mode.response;

import lombok.Data;
import lombok.ToString;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/1/29
 */
@Data
@ToString
public class ResponseResult implements Response {

    boolean success = SUCCESS;

    int code = SUCCESS_CODE;

    String message;

    public ResponseResult() {
    }

    public ResponseResult(ResultCode resultCode) {
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    //这个地方可以分别提供成功或者错误的结果
    public static ResponseResult SUCCESS(){return new ResponseResult(CommonCode.SUCCESS);}
    public static ResponseResult FAIL(){return new ResponseResult(CommonCode.FAIL);}
}
