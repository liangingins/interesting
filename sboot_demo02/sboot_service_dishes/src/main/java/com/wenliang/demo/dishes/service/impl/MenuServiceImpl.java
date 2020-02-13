package com.wenliang.demo.dishes.service.impl;

import com.wenliang.demo.dishes.mapper.MenuMapper;
import com.wenliang.demo.dishes.service.MenuService;
import com.wenliang.demo.entity.dishes.Menu;
import com.wenliang.demo.entity.dishes.response.DishesCode;
import com.wenliang.demo.entity.dishes.response.MenuResult;
import com.wenliang.demo.common.exception.ExceptionCast;
import com.wenliang.demo.common.mode.request.QueryRequest;
import com.wenliang.demo.common.mode.response.CommonCode;
import com.wenliang.demo.common.mode.response.QueryResult;
import com.wenliang.demo.common.mode.response.QueryResultResponse;
import com.wenliang.demo.common.mode.response.ResponseResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/2/3
 */
@Service
public class MenuServiceImpl  implements MenuService {

    @Resource
    MenuMapper menuMapper;

    @Override
    public QueryResultResponse findMenus() {
        List<Menu> menus = menuMapper.findMenus();
        QueryResult queryResult = new QueryResult();
        queryResult.setList(menus);
        queryResult.setTotal(menus.size());
        return  new QueryResultResponse(CommonCode.SUCCESS,queryResult);

    }

    @Override
    public MenuResult findById(String id) {
        if(id==null){
            return new MenuResult(CommonCode.PARAM_IS_NULL,null);
        }
        Menu menu = menuMapper.findById(Integer.parseInt(id));
        if(menu==null){
            return new MenuResult(DishesCode.DISHES_NOT_EXIST,null);
        }
        return new MenuResult(CommonCode.SUCCESS,menu);
    }

    @Override
    public MenuResult addMenu(Menu menu) {
        if(menu==null){
            return new MenuResult(CommonCode.PARAM_IS_NULL,null);
        }
        menuMapper.addMenu(menu);
        return new MenuResult(CommonCode.SUCCESS,menu);
    }

    /**
     * 这是用自定义异常抛出的形式
     * @param id
     * @param menu
     * @return
     */
    @Override
    public MenuResult updateMenu(String id, Menu menu) {
        if(id==null||menu==null){
            ExceptionCast.cast(CommonCode.PARAM_IS_NULL);
        }
        if(this.findById(id).getMenu()==null){
            ExceptionCast.cast(DishesCode.DISHES_NOT_EXIST);
        }
        menu.setId(Integer.parseInt(id));
        menuMapper.updateMenu(menu);
        return new MenuResult(CommonCode.SUCCESS,menu);
    }

    @Override
    public ResponseResult deleteOne(String id) {
        if(id==null){
            ExceptionCast.cast(CommonCode.PARAM_IS_NULL);
        }
        if(this.findById(id).getMenu()==null){
            ExceptionCast.cast(DishesCode.DISHES_NOT_EXIST);

        }
        menuMapper.deleteOne(Integer.parseInt(id));

        return new ResponseResult(CommonCode.SUCCESS);
    }

    /**
     * 按条件分页查询 需要结合mabatis的插件进行
     * @param queryRequest
     * @return
     */
    @Override
    public QueryResultResponse findPageMenus(QueryRequest queryRequest) {
        if(queryRequest==null){
            ExceptionCast.cast(CommonCode.PARAM_IS_NULL);
        }
        List<Menu> pageMenus = menuMapper.findPageMenus(queryRequest);
        QueryResult queryResult = new QueryResult();
        queryResult.setList(pageMenus);
        queryResult.setTotal(pageMenus.size());
        return null;
    }
}
