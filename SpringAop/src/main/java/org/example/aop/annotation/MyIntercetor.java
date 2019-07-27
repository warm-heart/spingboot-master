package org.example.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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

    @Before("anyMethod()")
    public void doAccessCheck(JoinPoint joinPoint) {
        System.out.println("前置通知");

        for (int i = 0; i < joinPoint.getArgs().length; i++) {
            System.out.println(joinPoint.getArgs()[i]);
        }
        System.out.println("目标方法名为:" + joinPoint.getSignature().getName());
        System.out.println("目标方法所属类的简单类名:" + joinPoint.getSignature().getDeclaringType().getSimpleName());
        System.out.println("目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));

    }

    @AfterReturning("anyMethod()")
    public void doAfterReturning() {
        System.out.println("后置通知");
    }

    @AfterReturning("anyMethod()")
    public void doAfter() {
        System.out.println("最终通知");
    }
}
