package org.example.aop.xml;

/**
 * @author wangqianlong
 * @create 2018-11-02 12:10
 */

public class LogHandle {
    public void LogBefore() {
        System.out.println("Log before method");
    }

    public void LogAfter() {
        System.out.println("Log After method");
    }
}
