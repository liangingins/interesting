package com.wenliang.demo.common.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @description: baseController 初始化操作
 * @author: cwl
 * @createDate: 2020/1/30
 */

//为什么这里可以进行初始化操作，难道就因为取的名字么？
public class BaseController {

    protected HttpServletRequest request;

    protected HttpServletResponse response;

    protected HttpSession session;

    //在所有方法运行之前运行。在这里进行初始化操作
    public void setReqAndRes(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        this.request = request;
        this.response = response;
        this.session = request.getSession();
        System.out.println("这里运行了。。。。。。。。。");
    }

}
