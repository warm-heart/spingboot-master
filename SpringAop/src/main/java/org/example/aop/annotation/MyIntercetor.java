package org.example.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

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


 /*   @Before("anyMethod()")
    public void doAccessCheck(JoinPoint joinPoint) {
        System.out.println("前置通知");

        for (int i = 0; i < joinPoint.getArgs().length; i++) {
            System.out.println("方法参数" + joinPoint.getArgs()[i]);
        }
        System.out.println("目标方法名为:" + joinPoint.getSignature().getName());
        System.out.println("目标方法所属类的简单类名:" + joinPoint.getSignature().getDeclaringType().getSimpleName());
        System.out.println("目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));

    }*/


    @Before("anyMethod()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("日志前置通知");
        //如果抛出异常业务方法不会执行,但其他的通知类型逻辑依旧会执行
        //throw new UnsupportedOperationException();
    }

    @After("anyMethod()")
    public void doAfter() {
        System.out.println("后置通知");
    }

    @AfterReturning(value = "anyMethod()", returning = "res")
    public void doAfterReturning(Object res) {

        System.out.println("返回通知" + "结果：" + res);
    }

    //异常通知 //如果异常被catch则不会执行
    @AfterThrowing(value = "anyMethod()", throwing = "eee")
    public void doThrowing(Exception eee) {
        System.out.println(eee.getMessage());
        System.out.println("异常通知");
    }
}
