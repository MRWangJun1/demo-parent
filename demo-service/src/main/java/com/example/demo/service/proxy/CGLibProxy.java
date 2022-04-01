package com.example.demo.service.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author : wangjun
 * @date : 2022/3/30  10:44
 */
public class CGLibProxy implements MethodInterceptor {

    // CGlib需要代理的目标对象
    private Object targetObject;

    public CGLibProxy(Object targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("检查权限：checkPopedom()!");
        return method.invoke(targetObject, args);
    }


    public static void main(String[] args) {
        //需要代理的类
        UserManagerImpl userManagerImpl = new UserManagerImpl();
        CGLibProxy cgLibProxy = new CGLibProxy(userManagerImpl);
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(userManagerImpl.getClass());
        enhancer.setCallback(cgLibProxy);
        UserManagerImpl userManager = (UserManagerImpl)enhancer.create();
        userManager.addUser("tom", "root");

    }

}
