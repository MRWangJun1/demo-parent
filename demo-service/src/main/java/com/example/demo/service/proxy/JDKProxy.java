package com.example.demo.service.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : wangjun
 * @date : 2022/3/30  10:07
 */
public class JDKProxy implements InvocationHandler {

    /**需要代理的目标对象*/
    private Object targetObject;

    public JDKProxy(Object targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("检查权限：checkPopedom()!");
        Object invoke = method.invoke(targetObject, args);
        return invoke;
    }


    public static void main(String[] args) {
        //需要代理的类
        UserManagerImpl userManagerImpl = new UserManagerImpl();
        //增强器
        JDKProxy jdkProxy = new JDKProxy(userManagerImpl);
        //生成代理对象
        UserManager newProxyInstance = (UserManager)Proxy.newProxyInstance(userManagerImpl.getClass().getClassLoader(), userManagerImpl.getClass().getInterfaces(), jdkProxy);
        //调用代理的方法
        newProxyInstance.addUser("tom", "root");
    }


}
