package org.example.aop.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:spring-aop.xml"}) //加载配置文件
public class HelloTest {

    @Autowired
    private Hello hello;

    @Test
    public void printHello() {
        hello.printHello();
    }

    @Test
    public void doPrint() {
    }
}