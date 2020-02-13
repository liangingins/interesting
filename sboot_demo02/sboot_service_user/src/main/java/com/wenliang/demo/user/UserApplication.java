package com.wenliang.demo.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/2/1
 */
@SpringBootApplication
@EntityScan(value = "com.wenliang.demo.entity.user")//实体类扫描
@ComponentScan(basePackages = {"com.wenliang.demo.api"})//扫描接口
@ComponentScan(basePackages = {"com.wenliang.demo.user"})//扫描当前项目下的所有类
public class UserApplication {
    public static void main(String[] args) {
         SpringApplication.run(UserApplication.class,args);
    }
}
