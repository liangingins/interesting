package com.wenliang.demo.dishes.service;

import com.wenliang.demo.entity.dishes.Menu;
import com.wenliang.demo.entity.dishes.response.MenuResult;
import com.wenliang.demo.common.mode.request.QueryRequest;
import com.wenliang.demo.common.mode.response.QueryResultResponse;
import com.wenliang.demo.common.mode.response.ResponseResult;

public interface MenuService {

    public QueryResultResponse findMenus();


    public MenuResult findById(String id);


    public MenuResult addMenu(Menu menu);


    public MenuResult updateMenu(String id,Menu menu);


    public ResponseResult deleteOne(String id);


    public QueryResultResponse findPageMenus(QueryRequest queryRequest);
}
