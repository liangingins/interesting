package com.wenliang.demo.dishes.mapper;

import com.wenliang.demo.common.mode.request.QueryRequest;
import com.wenliang.demo.entity.dishes.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {


    public List<Menu> findMenus();


    public Menu findById(@Param("id") int id);


    public void addMenu(@Param("menu") Menu menu);


    public void  updateMenu(@Param("menu") Menu menu);


    public void deleteOne(@Param("id") int id);


    public List<Menu> findPageMenus(@Param("queryRequest") QueryRequest queryRequest);

}
