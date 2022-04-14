package com.example.demo.web;

import com.example.demo.web.bootstrap.DemoWebApplication;
import com.example.demo.web.config.TestAware;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : wangjun
 * @date : 2022/4/8  17:53
 */
@SpringBootTest(classes = DemoWebApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class AwareTest {

    @Autowired
    TestAware testAware;

    @Test
    public void test1() {

        System.out.println("beanFactory:"+testAware.getBeanFactory());
        System.out.println("beanName:"+testAware.getBeanName());
        System.out.println("applicationContext:"+testAware.getAc());
        System.out.println("classLoader:"+testAware.getClassLoader());
        System.out.println(testAware);
    }

}
