package com.wenliang.demo.api.dishes;

import com.wenliang.demo.common.mode.request.QueryRequest;
import com.wenliang.demo.common.mode.response.QueryPageResponseResult;
import com.wenliang.demo.common.mode.response.QueryResultResponse;
import com.wenliang.demo.common.mode.response.ResponseResult;
import com.wenliang.demo.entity.dishes.Category;
import com.wenliang.demo.entity.dishes.request.CategoryRequest;
import com.wenliang.demo.entity.dishes.response.CategoryResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/2/3
 */
@Api(value = "菜单分类",description = "菜品分类信息")
public interface CategoryApi {

    @ApiOperation(value = "查询所有的菜品分类")
    public QueryResultResponse findCategorys();

    @ApiOperation(value = "根据id查询分类")
    public CategoryResult findById(String id);

    @ApiOperation(value = "添加分类")
    public CategoryResult addCategory(Category category);

    @ApiOperation(value = "修改分类")
    public CategoryResult updateCategory(String id,Category category);

    @ApiOperation(value = "根据id删除分类")
    public ResponseResult deleteOne(String id);

    @ApiOperation(value = "按条件分页查询分类信息")
    public QueryPageResponseResult findPage(QueryRequest queryRequest);

    @ApiOperation(value = "按条件查询")
    public QueryResultResponse findByCondition(CategoryRequest categoryRequest);




}
