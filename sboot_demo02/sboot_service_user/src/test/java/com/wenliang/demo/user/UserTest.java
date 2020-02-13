package com.wenliang.demo.user;

import com.wenliang.demo.entity.user.User;
import com.wenliang.demo.user.mapper.UserMapper;
import com.wenliang.demo.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/2/2
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {


    @Resource
    UserService userService;

    @Resource
    UserMapper userMapper;

    @Test
    public void findUsersTest(){
        List<User> users = userMapper.findUsers();
        System.out.println(users);
    }



}
