package com.task.Improve;

/**
 * @author wangqianlong
 * @create 2018-11-06 15:26
 */

public class MyThread1 extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("Mythread1 run priority="+this.getPriority());
    }
}
