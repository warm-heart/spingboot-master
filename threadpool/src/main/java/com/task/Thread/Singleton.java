package com.task.Thread;

/**
 * @author wangqianlong
 * @create 2019-07-25 9:50
 */

public class Singleton {


    private static Singleton singleTon;

    private Singleton() {
    }

    static Singleton getSingTon() {
        singleTon = new Singleton();
        return singleTon;
    }

}
