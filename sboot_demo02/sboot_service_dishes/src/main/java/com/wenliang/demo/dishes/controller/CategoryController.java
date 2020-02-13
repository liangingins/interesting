package com.wenliang.demo.dishes.controller;

import com.wenliang.demo.api.dishes.CategoryApi;
import com.wenliang.demo.common.exception.CustomException;
import com.wenliang.demo.common.mode.request.QueryRequest;
import com.wenliang.demo.common.mode.response.*;
import com.wenliang.demo.dishes.service.CategoryService;
import com.wenliang.demo.entity.dishes.Category;
import com.wenliang.demo.entity.dishes.request.CategoryRequest;
import com.wenliang.demo.entity.dishes.response.CategoryResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/2/3
 */
@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController implements CategoryApi {

    CategoryService categoryService;

    @Override
    @GetMapping("/findCategorys")
    public QueryResultResponse findCategorys() {
       return categoryService.findCategorys();
    }

    @Override
    @GetMapping("/findById/{id}")
    public CategoryResult findById(@PathVariable("id") String id) {
        CategoryResult categoryResult;
        try {
             categoryResult = categoryService.findById(id);
        }catch (CustomException e){
            e.printStackTrace();
            return new CategoryResult(e.getResultCode(),null);
        }
        return categoryResult;
    }

    @Override
    @PostMapping("/addCategory")
    public CategoryResult addCategory(@RequestBody Category category) {
        CategoryResult categoryResult;
        try {
             categoryResult = categoryService.addCategory(category);
        }catch (CustomException e){
            e.printStackTrace();
            return new CategoryResult(e.getResultCode(),null);

        }
        return categoryResult;
    }

    @Override
    @PutMapping("/updateCategory/{id}")
    public CategoryResult updateCategory(@PathVariable("id") String id, @RequestBody Category category) {
       CategoryResult categoryResult;
       try{
            categoryResult = categoryService.updateCategory(id, category);
       }catch (CustomException e){
           e.printStackTrace();
           return new CategoryResult(e.getResultCode(),null);

       }
       return categoryResult;
    }

    @Override
    @DeleteMapping("/deleteOne/{id}")
    public ResponseResult deleteOne(@PathVariable("id") String id) {
        ResponseResult responseResult;
        try {
            responseResult = categoryService.deleteOne(id);
        }catch (CustomException e){
            e.printStackTrace();
            return new ResponseResult(e.getResultCode());
        }
        return responseResult;
    }

    @Override
    @PostMapping("/findPage")
    public QueryPageResponseResult findPage(@RequestBody QueryRequest queryRequest) {
        QueryPageResponseResult queryPageResponseResult;
        try{
             queryPageResponseResult = categoryService.findPage(queryRequest);
        }catch (CustomException e){
            e.printStackTrace();
            return new QueryPageResponseResult(e.getResultCode(),null);

        }
        return queryPageResponseResult;
    }

    @Override
    @PostMapping("/findByCondition")
    public QueryResultResponse findByCondition(@RequestBody CategoryRequest categoryRequest) {
        List categorys = categoryService.findCategoryByCondition(categoryRequest);
        QueryResult queryResult =new QueryResult();
        queryResult.setList(categorys);
        queryResult.setTotal(categorys.size());
        return new QueryResultResponse(CommonCode.SUCCESS,queryResult);
    }
}
