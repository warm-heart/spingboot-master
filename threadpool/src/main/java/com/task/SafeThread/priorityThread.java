package com.task.SafeThread;



/**
 * @author wangqianlong
 * @create 2018-11-06 15:25
 */

public class priorityThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("Mythread run priority="+this.getPriority());
        priorityThread1 thread1 = new priorityThread1();
        thread1.start();
    }
}
