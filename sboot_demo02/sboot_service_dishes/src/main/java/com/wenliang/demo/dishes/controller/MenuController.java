package com.wenliang.demo.dishes.controller;

import com.wenliang.demo.api.dishes.MenuApi;
import com.wenliang.demo.dishes.service.MenuService;
import com.wenliang.demo.entity.dishes.Menu;
import com.wenliang.demo.entity.dishes.response.MenuResult;
import com.wenliang.demo.common.mode.request.QueryRequest;
import com.wenliang.demo.common.mode.response.QueryResultResponse;
import com.wenliang.demo.common.mode.response.ResponseResult;
import org.springframework.web.bind.annotation.*;
import com.wenliang.demo.common.exception.CustomException;

import javax.annotation.Resource;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/2/3
 */
@RestController
@RequestMapping("/menu")
public class MenuController implements MenuApi {

    @Resource
    MenuService menuService;


    @Override
    @GetMapping("/findMenus")
    public QueryResultResponse findMenus() {

        return menuService.findMenus();
    }

    @Override
    @GetMapping("/findById/{id}")
    public MenuResult findById(@PathVariable("id") String id) {

        return menuService.findById(id);
    }

    @Override
    @PostMapping("/addMenu")
    public MenuResult addMenu(@RequestBody Menu menu) {
        return menuService.addMenu(menu);
    }

    /**
     * 在控制层捕获并返回结果
     * @param id
     * @param menu
     * @return
     */
    @Override
    @PutMapping("/updateMenu/{id}")
    public MenuResult updateMenu(@PathVariable("id") String id,@RequestBody Menu menu) {

        MenuResult menuResult;
        try {
             menuResult = menuService.updateMenu(id, menu);
        }catch (CustomException e){
            e.printStackTrace();
            return new MenuResult(e.getResultCode(),null);
        }
        return menuResult;
    }

    @Override
    @DeleteMapping("/deleteOne/{id}")
    public ResponseResult deleteOne(@PathVariable("id") String id) {
        ResponseResult responseResult;
        try {
             responseResult = menuService.deleteOne(id);
        }catch (CustomException e){
            e.printStackTrace();
            return new ResponseResult(e.getResultCode());
        }
        return responseResult;
    }

    @Override
    @PostMapping("/findPageMenus")
    public QueryResultResponse findPageMenus(@RequestBody QueryRequest queryRequest) {
        QueryResultResponse queryResultResponse;
        try{
             queryResultResponse = menuService.findPageMenus(queryRequest);
        }catch (CustomException e){
            e.printStackTrace();
            return new QueryResultResponse(e.getResultCode(),null);
        }
        return queryResultResponse;
    }
}
