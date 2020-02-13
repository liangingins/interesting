package com.wenliang.demo.user.service;

import com.wenliang.demo.entity.user.User;
import com.wenliang.demo.entity.user.request.QueryUserPageRequest;
import com.wenliang.demo.entity.user.response.UserResult;
import com.wenliang.demo.common.mode.response.QueryResultResponse;
import com.wenliang.demo.common.mode.response.ResultCode;

public interface UserService {

    public QueryResultResponse findUsers();

    public UserResult findById(String id);

    public UserResult findByUsername(String username);

    public UserResult addUser(User user);

    public UserResult updateUser(String id,User user);

    public ResultCode deleteOne(String id);

    public QueryResultResponse findUsers(int page, int size, QueryUserPageRequest queryPageRequest);
}
