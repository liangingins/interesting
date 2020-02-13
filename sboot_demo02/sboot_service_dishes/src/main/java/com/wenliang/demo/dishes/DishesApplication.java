package com.wenliang.demo.dishes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description: 菜品启动类
 * @author: cwl
 * @createDate: 2020/2/3
 */
@SpringBootApplication
@EntityScan(value = "com.wenliang.demo.entity.dishes")
@ComponentScan(basePackages = {"com.wenliang.demo.api"})
@ComponentScan(basePackages = {"com.wenliang.demo.dishes"})
public class DishesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DishesApplication.class,args);
    }
}
