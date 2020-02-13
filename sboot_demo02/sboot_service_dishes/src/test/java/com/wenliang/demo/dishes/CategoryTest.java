package com.wenliang.demo.dishes;

import com.wenliang.demo.dishes.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:
 * @author: cwl
 * @createDate: 2020/2/11
 */
@SpringBootTest()
@ContextConfiguration(locations ={"classpath:application.yml"})
@RunWith(SpringRunner.class)
public class CategoryTest {


    @Autowired
    CategoryService categoryService;



    @Test
    public  void test01() {
//        Map map = new HashMap();
//        map.put("name","特色");
//        List categorys = categoryService.findCategoryByCondition();
//        System.out.println(categorys);

    }


}
