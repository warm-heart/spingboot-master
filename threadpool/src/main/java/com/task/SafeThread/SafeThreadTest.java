package com.task.SafeThread;


import com.task.ThreadLocal.Format;
import com.task.ThreadLocal.FormatThread;

/**
 * @author wangqianlong
 * @create 2019-04-18 21:48
 */

public class SafeThreadTest {
    public static void main(String[] args) throws InterruptedException {
        CountThread countThread = new CountThread();




        for (int i = 0; i < 100; i++) {
            new Thread(countThread, "线程" + i).start();
        }


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
        priorityThread myThread = new priorityThread();
        myThread.start();

    }
}
