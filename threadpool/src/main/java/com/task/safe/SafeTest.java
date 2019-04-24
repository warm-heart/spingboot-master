package com.task.safe;


/**
 * @author wangqianlong
 * @create 2019-04-18 21:48
 */

public class SafeTest {
    public static void main(String[] args) throws InterruptedException {
        SafeThread safeThread = new SafeThread();

        Format format =new Format();
        FormatThread formatThread = new FormatThread(format);


        for (int i = 0; i <100 ; i++) {
            new Thread(safeThread,"线程"+i).start();
        }

/*
        for (int i = 0; i <100 ; i++) {
            new Thread(formatThread,"线程"+i).start();
        }*/
    }
}
