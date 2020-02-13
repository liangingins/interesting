package com.wenliang.demo.entity.dishes.response;

import com.wenliang.demo.common.mode.response.ResponseResult;
import com.wenliang.demo.common.mode.response.ResultCode;
import com.wenliang.demo.entity.dishes.Category;
import lombok.Data;
import lombok.ToString;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/2/7
 */
@Data
@ToString
public class CategoryResult extends ResponseResult {

    Category category;


    public CategoryResult(ResultCode resultCode, Category category) {
        super(resultCode);
        this.category = category;
    }
}
