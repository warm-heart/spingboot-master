package com.task.Thread;

/**
 * @author wangqianlong
 * @create 2018-11-05 16:41
 */

public class ThreeThread extends Thread {
    public ThreeThread() {
    }

    public ThreeThread(Runnable target) {
        super(target);
    }

    @Override
    public void run() {
        super.run();
        System.out.println("It is The ThreeThread");
    }
}
