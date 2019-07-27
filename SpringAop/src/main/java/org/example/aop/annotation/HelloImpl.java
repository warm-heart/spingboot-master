package org.example.aop.annotation;

import org.springframework.stereotype.Service;

/**
 * @author wangqianlong
 * @create 2018-11-04 15:59
 */
@Service
public class HelloImpl implements Hello {
    @Override
    public void printHello(String s) {
        System.out.println("注解式AOP printHello方法:   "+s);
    }

    @Override
    public void doPrint() {
        System.out.println("注解式AOP  doPrint方法");
    }
}
