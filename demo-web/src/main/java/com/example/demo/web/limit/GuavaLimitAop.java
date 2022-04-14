package com.example.demo.web.limit;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : wangjun
 * @date : 2022/4/14  11:29
 */

@Aspect
@Slf4j
@Configuration
public class GuavaLimitAop {

    private static final Map<String, RateLimiter> rateLimiterMap = new ConcurrentHashMap<>();

    @Pointcut("@annotation(com.example.demo.web.limit.GuavaLimit)")
    public void guavaLimitPointCut() {

    }


    @Around("guavaLimitPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        GuavaLimit annotation = method.getAnnotation(GuavaLimit.class);
        String key = annotation.key();
        if (rateLimiterMap.get(key) == null) {
            //初始化
            rateLimiterMap.put(key, RateLimiter.create(annotation.qps(), annotation.timeOut(), annotation.timeUnit()));
        }
        RateLimiter rateLimiter = rateLimiterMap.get(key);
        if (rateLimiter.tryAcquire()) {
            return pjp.proceed();
        } else {
            log.warn("超过限制值");
            throw new BusinessException("超过限制值");
        }
    }


}
