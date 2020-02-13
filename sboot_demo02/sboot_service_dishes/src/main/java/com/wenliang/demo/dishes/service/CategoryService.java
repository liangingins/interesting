package com.wenliang.demo.dishes.service;

import com.wenliang.demo.common.mode.request.QueryRequest;
import com.wenliang.demo.common.mode.response.QueryPageResponseResult;
import com.wenliang.demo.common.mode.response.QueryResultResponse;
import com.wenliang.demo.common.mode.response.ResponseResult;
import com.wenliang.demo.entity.dishes.Category;
import com.wenliang.demo.entity.dishes.request.CategoryRequest;
import com.wenliang.demo.entity.dishes.response.CategoryResult;

import java.util.List;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/2/3
 */
public interface CategoryService {

    public QueryResultResponse findCategorys();

    public CategoryResult findById(String id);

    public CategoryResult addCategory(Category category);

    public CategoryResult updateCategory(String id,Category category);

    public ResponseResult deleteOne(String id);

    public QueryPageResponseResult findPage(QueryRequest queryRequest);

    public List findCategoryByCondition(CategoryRequest categoryRequest);
}
