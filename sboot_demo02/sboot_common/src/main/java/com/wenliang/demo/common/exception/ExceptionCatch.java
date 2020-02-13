package com.wenliang.demo.common.exception;

import com.google.common.collect.ImmutableMap;
import com.wenliang.demo.common.mode.response.CommonCode;
import com.wenliang.demo.common.mode.response.ResponseResult;
import com.wenliang.demo.common.mode.response.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @description: 异常增强类
 * @author: cwl
 * @createDate: 2020/1/30
 */

@ControllerAdvice//异常增强类你
public class ExceptionCatch {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatch.class);

    private static  ImmutableMap<Class<? extends Throwable>, ResultCode> EXCEPTIONS;

    private static  ImmutableMap.Builder<Class<? extends Throwable>,ResultCode> builder = ImmutableMap.builder();


    public ResponseResult exception(Exception e){
        LOGGER.error("Catch com.wenliang.demo.common.exception : {} \r\n com.wenliang.demo.common.exception : ",e.getMessage(),e);
        if(EXCEPTIONS==null){
            EXCEPTIONS = builder.build();
        }
        final ResultCode resultCode = EXCEPTIONS.get(e.getClass());
        final ResponseResult responseResult;
        if(resultCode!=null){
            responseResult = new ResponseResult(resultCode);
        }else {
            responseResult = new ResponseResult(CommonCode.SERVER_ERROR);
        }

        return responseResult;
    }

    public ResponseResult customException(CustomException e){
        LOGGER.error("Catch com.wenliang.demo.common.exception : {} \r\n com.wenliang.demo.common.exception : ",e.getMessage(),e);
        final ResultCode resultCode = e.getResultCode();
        return new ResponseResult(resultCode);
    }

}
