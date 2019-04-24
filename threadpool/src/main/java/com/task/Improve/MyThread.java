package com.task.Improve;



/**
 * @author wangqianlong
 * @create 2018-11-06 15:25
 */

public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("Mythread run priority="+this.getPriority());
        MyThread1 thread1 = new MyThread1();
        thread1.start();
    }
}
