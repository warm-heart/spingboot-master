package com.task.ThreadLocal;


import com.task.SafeThread.CountThread;

/**
 * @author wangqianlong
 * @create 2019-04-18 21:48
 */

public class ThreadLocalTest {
    public static void main(String[] args) throws InterruptedException {

     /*   SimpleFormatTest format = new SimpleFormatTest();
        FormatThread formatThread = new FormatThread(format);


        for (int i = 0; i <100 ; i++) {
            new Thread(formatThread,"线程"+i).start();
        }*/
        threadLocal threadLocal = new threadLocal();
        threadLocal.set();
        System.out.println(threadLocal.get());

    }
}
