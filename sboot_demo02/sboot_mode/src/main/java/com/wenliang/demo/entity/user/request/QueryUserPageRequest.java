package com.wenliang.demo.entity.user.request;

import lombok.Data;
import lombok.ToString;
import com.wenliang.demo.common.mode.request.RequestData;

import java.util.Date;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/1/31
 */
@Data
@ToString
public class QueryUserPageRequest extends RequestData  {

    private int  id;

    private String username;

    private int  password;

    private String nikename;

    private Date createtime;



}
