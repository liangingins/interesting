package com.wenliang.demo.dishes.mapper;

import com.wenliang.demo.entity.dishes.Category;
import com.wenliang.demo.entity.dishes.request.CategoryRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CategoryMapper{

    public List<Category> findCategorys();

    public Category findById(int  id);

    public void  addCategory( Category category);

    public void  updateCategory( Category category);

    public void deleteOne(@Param("id") int id);

    public List<Category> findCategoryPages(Map<String,String> map);

    public List<Category> findCategoryByCondition(CategoryRequest categoryRequest);
}
