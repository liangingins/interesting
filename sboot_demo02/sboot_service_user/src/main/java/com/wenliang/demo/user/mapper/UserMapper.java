package com.wenliang.demo.user.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wenliang.demo.entity.user.User;
import com.wenliang.demo.entity.user.request.QueryUserPageRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper  extends BaseMapper<User> {

    @Select("select * from user ")
    public List<User> findUsers();

    @Select("select * from user where username = #{username}")
    public User findByUsername(@Param("username") String username);

    public List<User> findUsers(int page, int size, QueryUserPageRequest queryPageRequest);
}
