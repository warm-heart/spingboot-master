package org.example.aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangqianlong
 * @create 2018-11-02 11:59
 */

public class AopTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
        //helloWorld1不能打印切点，因为不是从spring Ioc里取得的bean
        HelloWorld helloWorld1 = new HelloWorldImpl1();
        HelloWorld helloWorld2 = (HelloWorld) context.getBean("helloWorldImpl2");

      //只打印一个切点
        helloWorld2.printHelloWorld();
        System.out.println("\n");
        //do打印出两个切点 spring-aop.xml配置的logHandle只配置do*方法
        helloWorld2.doPrint();
    }
}
