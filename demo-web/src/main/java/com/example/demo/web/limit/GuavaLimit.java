package com.example.demo.web.limit;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * @author : wangjun
 * @date : 2022/4/14  11:23
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GuavaLimit {

    String key() default "";

    /**
     * 每秒创建令牌个数，默认:10
     */
    double qps() default 100;

    /**
     * 获取令牌等待超时时间 默认:500
     */
    long timeOut() default 500;


    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;

}
