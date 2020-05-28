package org.example.aop.annotation;

import org.springframework.stereotype.Service;

/**
 * @author wangqianlong
 * @create 2018-11-04 15:59
 */
@Service
public class HelloImpl implements Hello {
    @Override
    public String printHello(String s) {
        System.out.println("业务方法执行");

   /*     try {
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("catch 起来");
        }*/
        return s;
    }

    @Override
    public void doPrint() {
        System.out.println("注解式AOP  doPrint方法");
    }
}
