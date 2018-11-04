package org.example.aop.annotation;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author wangqianlong
 * @create 2018-11-04 15:51
 */
@Component
@Aspect
public class MyIntercetor {

    //声明一个切入点  相当于xml配置中的pointcut标签
    @Pointcut("execution(* org.example.aop.annotation.Hello.*(..))")
    public void anyMethod() {
    }

    @Before("anyMethod()")
    public void doAccessCheck(){
        System.out.println("前置通知");
    }

    @AfterReturning("anyMethod()")
    public void doAfterReturning(){
        System.out.println("后置通知");
    }

    @AfterReturning("anyMethod()")
    public void doAfter(){
        System.out.println("最终通知");
    }
}
