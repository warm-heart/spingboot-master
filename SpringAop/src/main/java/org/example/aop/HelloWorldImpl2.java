package org.example.aop;

/**
 * @author wangqianlong
 * @create 2018-11-02 11:44
 */

public class HelloWorldImpl2 implements HelloWorld {
    @Override
    public void printHelloWorld() {
        System.out.println("Enter HelloWorldImpl222.printHelloWorld()");
    }

    @Override
    public void doPrint() {
        System.out.println("Enter HelloWorldImpl222.doPrint()");
    }
}
