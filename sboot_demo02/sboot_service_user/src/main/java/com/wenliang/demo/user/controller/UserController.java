package com.wenliang.demo.user.controller;

import com.wenliang.demo.api.user.UserApi;
import com.wenliang.demo.entity.user.User;
import com.wenliang.demo.entity.user.request.QueryUserPageRequest;
import com.wenliang.demo.entity.user.response.UserResult;
import com.wenliang.demo.user.service.UserService;
import com.wenliang.demo.common.mode.response.CommonCode;
import com.wenliang.demo.common.mode.response.QueryResultResponse;
import com.wenliang.demo.common.mode.response.ResultCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/2/1
 */
@RestController
@RequestMapping("/user")
public class UserController implements UserApi {

    @Resource
    UserService userService;

    @Override
    @GetMapping("/findUsers")
    public QueryResultResponse findUsers() {
        return  userService.findUsers();
    }

    @Override
    @GetMapping("/findOne/{username}")
    public UserResult findByUsername(@PathVariable("username") String username) {
        return userService.findByUsername(username);
    }

    @Override
    @PostMapping("/addUser")
    public UserResult addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @Override
    @PutMapping("/updateUser/{id}")
    public UserResult updateUser(@PathVariable("id") String id ,@RequestBody User user) {
        return userService.updateUser(id,user);
    }

    @Override
    @DeleteMapping("/deleteOne/{id}")
    public ResultCode deleteOne(@PathVariable("id") String id) {
        try {
            return userService.deleteOne(id);
        }catch (Exception e){
            e.printStackTrace();
            return CommonCode.FAIL;
        }
    }

    @Override
    @GetMapping("/findPageUsers/{page}/{size}")
    public QueryResultResponse findUsers(@PathVariable("page") int page,@PathVariable("size") int size,  QueryUserPageRequest queryUserPageRequest) {

        return userService.findUsers(page,size,queryUserPageRequest);
    }
}
