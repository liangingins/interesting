package com.wenliang.demo.api.user;

import com.wenliang.demo.common.mode.response.QueryResultResponse;
import com.wenliang.demo.common.mode.response.ResultCode;
import com.wenliang.demo.entity.user.User;
import com.wenliang.demo.entity.user.request.QueryUserPageRequest;
import com.wenliang.demo.entity.user.response.UserResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/1/31
 */
@Api(value = "用户接口", description = "用户信息接口，用于登陆验证等")
public interface UserApi {


    @ApiOperation(value = "查询所用用户")
    public QueryResultResponse findUsers();


    @ApiOperation(value = "根据用户名查询用户")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "path", dataType = "String")
    public UserResult findByUsername(String username);

    @ApiOperation(value = "添加用户")
    public UserResult addUser( User user);

    @ApiOperation(value = "修改用户")
    public UserResult updateUser(String id,User user);

    @ApiOperation(value = "根据用户id删除用户")
    public ResultCode deleteOne(String id);

    @ApiOperation(value = "按条件分页查询")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "page", value = "起始页", required = false, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页显示数量", required = false, paramType = "path", dataType = "int")}
    )
    public QueryResultResponse findUsers(int page, int size, QueryUserPageRequest queryPageRequest);


}
