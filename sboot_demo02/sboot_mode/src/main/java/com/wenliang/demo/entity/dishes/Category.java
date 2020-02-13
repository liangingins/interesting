package com.wenliang.demo.entity.dishes;

import lombok.Data;
import lombok.ToString;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/2/3
 */
@Data
@ToString
public class Category  {

    public static final long serialVersionUID = 1L;

    private int id;

    private String name;

    private String description;

}
