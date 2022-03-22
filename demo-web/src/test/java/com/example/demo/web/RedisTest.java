package com.example.demo.web;

import com.example.demo.web.bootstrap.DemoWebApplication;

import com.example.demo.web.redis.RedisUtils;
import com.example.demo.web.redis.Student;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author : wangjun
 * @date : 2022/3/10  15:09
 */
@SpringBootTest(classes = DemoWebApplication.class)
@RunWith(SpringRunner.class)
public class RedisTest {


//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;

//    @Resource
//    private RedisTemplate<String,Object> redisTemplate;

    private Student student;


    @Before
    public void initStudent() {
        student = new Student();
        student.setDaysId("456");
        student.setItemNumber(123);
        student.setOpenId("dawda");
        student.setTitle("title");
    }




//    @Test
//    public void set() {
//        redisTemplate.opsForValue().set("myKey", "myValue");
//        System.out.println(redisTemplate.opsForValue().get("myKey"));
//    }



//    @Test
//    public void setObject(){
//        redisTemplate.setKeySerializer(RedisSerializer.string());
//        redisTemplate.setValueSerializer(RedisSerializer.string());
//        redisTemplate.opsForValue().set("myKey1","myValue");
//        System.out.println(redisTemplate.opsForValue().get("myKey"));
//    }


    @Autowired
    private RedisTemplate<String,Student> redisTemplate;
    @Autowired
    private RedisUtils redisUtils;


    @Test
    public void testStudent(){
        this.redisTemplate.opsForValue().set("student",student);
        System.out.println((redisTemplate.opsForValue().get("student")));
    }



    @Test
    public void testRedisConfig(){
        redisUtils.set("wwww","eeeee");
    }


}
