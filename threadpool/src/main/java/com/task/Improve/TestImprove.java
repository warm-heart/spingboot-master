package com.task.Improve;


/**
 * @author wangqianlong
 * @create 2018-11-06 15:04
 */

public class TestImprove {
    public static void main(String[] args) {
        //线程安全测试
        Thread thread = new AThread();
        //thread.run();
        thread.start();

        Thread thread1 = new BThread();
        thread1.start();


        //线程优先级测试
        System.out.println("main thread priority" + Thread.currentThread().getPriority());
        // System.out.println(Thread.currentThread().getName()); //打印为main
        Thread.currentThread().setPriority(6);
        MyThread myThread = new MyThread();
        myThread.start();


    }
}
