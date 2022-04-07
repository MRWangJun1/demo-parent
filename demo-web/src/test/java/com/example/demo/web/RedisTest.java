package com.example.demo.web;

import com.example.demo.web.bootstrap.DemoWebApplication;


import org.junit.Test;
import org.junit.runner.RunWith;

import org.redisson.api.RAtomicLong;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;


/**
 * @author : wangjun
 * @date : 2022/3/10  15:09
 */
@SpringBootTest(classes = DemoWebApplication.class)
@RunWith(SpringRunner.class)
public class RedisTest {

    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void query() {
        RAtomicLong ceshi123 = redissonClient.getAtomicLong("ceshi123");
        System.out.println(ceshi123.get());
        RBucket<String> bucket = redissonClient.getBucket("demo:123");
        System.out.println(bucket.get());
        RBucket<String> updateTimeBucket = redissonClient.getBucket("yaoex-searchcenter-remote:lastProductUpdateTime");
        System.out.println(updateTimeBucket.get());
    }

    @Test
    public void save() throws InterruptedException {
        RBucket<String> bucket = redissonClient.getBucket("demo:123");
        bucket.set("hello",5, TimeUnit.SECONDS);
        System.out.println(bucket.get());
        System.out.println(bucket.get());
        Thread.sleep(10000);
        System.out.println(bucket.get());
    }



    public void setInfo(){

        RAtomicLong timesAtomicLong = redissonClient.getAtomicLong("name");

        redissonClient.getLock("lock");
//        timesAtomicLong.get


    }
}
