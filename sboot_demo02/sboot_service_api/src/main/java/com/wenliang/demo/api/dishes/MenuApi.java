package com.wenliang.demo.api.dishes;

import com.wenliang.demo.entity.dishes.Menu;
import com.wenliang.demo.entity.dishes.response.MenuResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import com.wenliang.demo.common.mode.request.QueryRequest;
import com.wenliang.demo.common.mode.response.QueryResultResponse;
import com.wenliang.demo.common.mode.response.ResponseResult;

/**
 * @description: 菜单
 * @author: cwl
 * @createDate: 2020/2/3
 */
@Api(value = "菜单接口",description = "菜品的增、删、改、查")
public interface MenuApi {

    @ApiOperation(value = "查询所有的菜单")
    public QueryResultResponse findMenus();

    @ApiOperation(value = "根据id查询菜品")
    @ApiImplicitParam(name = "id",value = "菜品id",paramType = "path",required = true,dataType = "String")
    public MenuResult findById(String id);

    @ApiOperation(value = "添加菜品")
    public MenuResult addMenu(Menu menu);

    @ApiOperation(value = "修改菜品")
    public MenuResult updateMenu(String id,Menu menu);

    @ApiOperation(value = "根据id删除菜品")
    public ResponseResult deleteOne(String id);

    @ApiOperation(value = "按条件分页查询")
    public QueryResultResponse findPageMenus(QueryRequest queryRequest);
}
