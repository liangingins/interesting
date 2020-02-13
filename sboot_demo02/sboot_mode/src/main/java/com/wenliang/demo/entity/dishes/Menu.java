package com.wenliang.demo.entity.dishes;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @description: 菜品详情
 * @author: cwl
 * @createDate: 2020/2/3
 */
@Data
@ToString
public class Menu {

    public static final long serialVersionUID = 1L;

    private int id;

    private String name;

    private int categoryId;

    private String description;

    private Date createtime;

    private Date updatetime;

    private String images;

    private String step;

    private int userId;

    private String note;
}
