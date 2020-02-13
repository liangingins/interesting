package com.wenliang.demo.user.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.wenliang.demo.entity.user.User;
import com.wenliang.demo.entity.user.request.QueryUserPageRequest;
import com.wenliang.demo.entity.user.response.UserCode;
import com.wenliang.demo.entity.user.response.UserResult;
import com.wenliang.demo.user.mapper.UserMapper;
import com.wenliang.demo.user.service.UserService;
import com.wenliang.demo.common.exception.ExceptionCast;
import com.wenliang.demo.common.mode.response.CommonCode;
import com.wenliang.demo.common.mode.response.QueryResult;
import com.wenliang.demo.common.mode.response.QueryResultResponse;
import com.wenliang.demo.common.mode.response.ResultCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 用户服务层
 * @author: cwl
 * @createDate: 2020/2/1
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public QueryResultResponse findUsers() {
        List<User> users = userMapper.findUsers();
        System.out.println(users);
        QueryResultResponse queryResultResponse;
        if (users != null && users.size() > 0) {
            QueryResult<User> queryResult = new QueryResult<User>();
            queryResult.setList(users);
            queryResult.setTotal(users.size());
            return queryResultResponse = new QueryResultResponse(CommonCode.SUCCESS, queryResult);
        } else {
            return queryResultResponse = new QueryResultResponse(UserCode.USER_NOT_EXSIT, null);

        }
    }

    @Override
    public UserResult findById(String id) {
        if(id==null){
            return new UserResult(UserCode.USER_NOT_EXSIT,null);
        }
        int uid = Integer.parseInt(id);
        User user = userMapper.selectById(uid);
        return new UserResult(CommonCode.SUCCESS,user);
    }

    @Override
    public UserResult findByUsername(String username) {

        User user = userMapper.findByUsername(username);
        if (user != null) {
            return new UserResult(CommonCode.SUCCESS, user);

        } else {
            return  new UserResult(UserCode.USER_NOT_EXSIT, null);

        }
    }

    @Override
    public UserResult addUser(User user) {
        if(user==null){
            //ExceptionCast.cast(CommonCode.ADD_IS_NULL);
            return new UserResult(UserCode.ADD_IS_NULL,null);
        }
        UserResult userResult;
        userMapper.insert(user);
        User newUser = userMapper.selectOne(user);
        return userResult = new UserResult(CommonCode.SUCCESS,user);
    }

    @Override
    public UserResult updateUser(String id,User user) {
        //首先根据id查询出是否有该用户
        UserResult userResult = findById(id);
        User oldUser = userResult.getUser();
        if(oldUser==null){
            return new UserResult(CommonCode.FAIL,null);
        }else{
//            oldUser.setNikename(user.getNikename());
//            oldUser.setUsername(user.getUsername());
//            oldUser.setUpdatetime(user.getUpdatetime());
            user.setId(Integer.parseInt(id));
            userMapper.updateById(user);
            User newUser = this.findById(id).getUser();
            return new UserResult(CommonCode.SUCCESS,newUser);
        }
    }

    @Override
    public ResultCode deleteOne(String id) {
        if(id==null){
            ExceptionCast.cast(CommonCode.FAIL);
        }
        int uid = Integer.parseInt(id);
        User user = userMapper.selectById(uid);
        if(user==null){
            return UserCode.USER_NOT_EXSIT;

        }else{
            userMapper.deleteById(uid);
            return CommonCode.SUCCESS;
        }
    }

    /**
     * @param page
     * @param size
     * @param queryUserPageRequest
     * @return QueryResultResponse
     */
    @Override
    public QueryResultResponse findUsers(int page, int size, QueryUserPageRequest queryUserPageRequest) {

        if (queryUserPageRequest == null) {
            queryUserPageRequest = new QueryUserPageRequest();
        }

        Wrapper wrapper = this.getWrapper(queryUserPageRequest);

        if(page<=0){
            page = 1;
        }
        if(size<=0){
            size = 5;
        }

        Page<User> pg = new Page<User>(page, size);
        List users = userMapper.selectPage(pg, wrapper);


        QueryResultResponse queryResultResponse;
        if(users!=null){
            QueryResult<User> queryResult = new QueryResult<User>();
            queryResult.setList(users);
            queryResult.setTotal(users.size());
            return queryResultResponse = new QueryResultResponse(CommonCode.SUCCESS,queryResult);
        }else{
            return queryResultResponse = new QueryResultResponse(UserCode.USER_NOT_EXSIT,null);
        }

    }

    public Wrapper getWrapper(QueryUserPageRequest queryUserPageRequest) {
        Wrapper wrapper = new EntityWrapper();

        if (queryUserPageRequest.getId() != 0) {
            wrapper.eq("id", queryUserPageRequest.getId());
        }
        if (queryUserPageRequest.getNikename() != null) {
            wrapper.eq("nikename", queryUserPageRequest.getNikename());
        }
        if (queryUserPageRequest.getUsername() != null) {
            wrapper.eq("username", queryUserPageRequest.getUsername());
        }

        if (queryUserPageRequest.getCreatetime() != null) {
            wrapper.gt("createtime", queryUserPageRequest.getCreatetime());
        }
        return wrapper;
    }
}
