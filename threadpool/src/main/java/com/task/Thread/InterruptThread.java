package com.task.Thread;

/**
 * @author wangqianlong
 * @create 2019-08-02 9:42
 */

public class InterruptThread implements Runnable {
    @Override
    public void run() {

        try {
            for (int i = 0; i < 500000; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("已经是停止状态了!我要退出了!");
                    throw new InterruptedException();
                }
                System.out.println("i=" + (i + 1));
            }
                System.out.println("我在for下面");
        } catch (InterruptedException e) {
            System.out.println("InterruptThread.java类run方法中的catch！");
            e.printStackTrace();
        }

    }
}
