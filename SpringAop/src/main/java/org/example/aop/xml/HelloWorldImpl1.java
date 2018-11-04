package org.example.aop.xml;

/**
 * @author wangqianlong
 * @create 2018-11-02 11:44
 */

public class HelloWorldImpl1 implements HelloWorld {
    @Override
    public void printHelloWorld() {
        System.out.println("Enter HelloWorldImpl1111.printHelloWorld()");

    }

    @Override
    public void doPrint() {
        System.out.println("Enter HelloWorldImpl1111.doPrint()");
    }
}
