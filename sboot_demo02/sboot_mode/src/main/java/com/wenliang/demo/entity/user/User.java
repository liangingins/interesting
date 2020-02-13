package com.wenliang.demo.entity.user;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/1/31
 */
@Data
@ToString
public class User implements Serializable {

    private int  id;

    private String username;

    private int  password;

    private String nikename;

    private Date createtime;

    private Date updatetime;


}
