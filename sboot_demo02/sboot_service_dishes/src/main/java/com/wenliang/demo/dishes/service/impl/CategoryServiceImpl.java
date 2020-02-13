package com.wenliang.demo.dishes.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wenliang.demo.common.exception.ExceptionCast;
import com.wenliang.demo.common.mode.request.QueryRequest;
import com.wenliang.demo.common.mode.response.*;
import com.wenliang.demo.common.utils.PageUtils;
import com.wenliang.demo.dishes.mapper.CategoryMapper;
import com.wenliang.demo.dishes.service.CategoryService;
import com.wenliang.demo.entity.dishes.Category;
import com.wenliang.demo.entity.dishes.request.CategoryRequest;
import com.wenliang.demo.entity.dishes.response.CategoryResult;
import com.wenliang.demo.entity.dishes.response.DishesCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/2/3
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    CategoryMapper categoryMapper;

    @Override
    public QueryResultResponse findCategorys() {
        List<Category> categorys = categoryMapper.findCategorys();
        QueryResult<Category> queryResult = new QueryResult<Category>();
        queryResult.setList(categorys);
        queryResult.setTotal(categorys.size());
        return new QueryResultResponse(CommonCode.SUCCESS, queryResult);
    }

    @Override
    public CategoryResult findById(String id) {
        if (id == null) {
            ExceptionCast.cast(CommonCode.PARAM_IS_NULL);
        }
        Category category = categoryMapper.findById(Integer.parseInt(id));
        if (category == null) {
            return new CategoryResult(DishesCode.DISHES_NOT_EXIST, null);

        }
        return new CategoryResult(CommonCode.SUCCESS, category);
    }

    @Override
    public CategoryResult addCategory(Category category) {
        if (category == null) {
            ExceptionCast.cast(CommonCode.PARAM_IS_NULL);
        }
        categoryMapper.addCategory(category);
        return new CategoryResult(CommonCode.SUCCESS, category);
    }

    @Override
    public CategoryResult updateCategory(String id, Category category) {
        if (id == null || category == null) {
            ExceptionCast.cast(CommonCode.PARAM_IS_NULL);
        }
        if (this.findById(id).getCategory() == null) {
            ExceptionCast.cast(DishesCode.DISHES_NOT_EXIST);
        }
        category.setId(Integer.parseInt(id));
        categoryMapper.updateCategory(category);
        return new CategoryResult(CommonCode.SUCCESS, category);
    }

    @Override
    public ResponseResult deleteOne(String id) {
        if (id == null) {
            ExceptionCast.cast(CommonCode.PARAM_IS_NULL);
        }
        if (this.findById(id).getCategory() == null) {
            ExceptionCast.cast(DishesCode.DISHES_NOT_EXIST);
        }
        categoryMapper.deleteOne(Integer.parseInt(id));
        return new ResponseResult(CommonCode.SUCCESS);
    }

    @Override
    public QueryPageResponseResult findPage(QueryRequest queryRequest) {
        PageInfo<Category> pageInfo = this.findCategoryPages(queryRequest);
        QueryPageResult queryPageResult = PageUtils.getQueryPageResult(pageInfo);
        return new QueryPageResponseResult(CommonCode.SUCCESS, queryPageResult);
    }


    public PageInfo<Category> findCategoryPages(QueryRequest queryRequest) {
        if (queryRequest == null) {
            ExceptionCast.cast(CommonCode.PARAM_IS_NULL);
        }
        if (queryRequest.getPage() <= 0) {
            queryRequest.setPage(1);
        }
        if (queryRequest.getSize() <= 0) {
            queryRequest.setSize(3);
        }
        PageHelper.startPage(queryRequest.getPage(), queryRequest.getSize());
        List<Category> categoryPages = categoryMapper.findCategoryPages(queryRequest.getMap());
        return new PageInfo<Category>(categoryPages);
    }

    @Override
    public  List findCategoryByCondition(CategoryRequest categoryRequest){
        return categoryMapper.findCategoryByCondition(categoryRequest);
    }
}
