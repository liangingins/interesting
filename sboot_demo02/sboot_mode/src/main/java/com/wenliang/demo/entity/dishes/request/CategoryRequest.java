package com.wenliang.demo.entity.dishes.request;

import com.wenliang.demo.entity.dishes.Category;
import lombok.Data;
import lombok.ToString;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/2/11
 */
@Data
@ToString
public class CategoryRequest  extends Category {

    public static final long serialVersionUID = 1L;

    private int id;

    private String name;

    private String description;

}
