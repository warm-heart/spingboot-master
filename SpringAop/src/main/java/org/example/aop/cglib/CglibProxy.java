package org.example.aop.cglib;


import org.example.aop.annotation.Hello;
import org.example.aop.annotation.HelloImpl;

import org.springframework.cglib.core.SpringNamingPolicy;
import org.springframework.cglib.proxy.Enhancer;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author wangqianlong
 * @create 2020-08-28 19:32
 */
public class CglibProxy {

    public Object getProxy(Class clazz) {

        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        enhancer.setNamingPolicy(SpringNamingPolicy.INSTANCE);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("执行方法之前");
                Object res = methodProxy.invokeSuper(o, objects);
                System.out.println("执行方法之后");
                return res;
            }

        });
        // enhancer.setCallbackFilter();
        return enhancer.create();
    }

    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        Hello helloProxy = (Hello) cglibProxy.getProxy(HelloImpl.class);
        String res = helloProxy.printHello("hello");
        System.out.println("结果： " + res);
    }
}
