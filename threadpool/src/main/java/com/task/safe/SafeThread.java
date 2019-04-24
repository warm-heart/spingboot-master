package com.task.safe;

/**
 * @author wangqianlong
 * @create 2019-04-18 21:46
 */

public class SafeThread extends Thread {

    int count = 50;

     public void run() {
        while (count > 0) {
            count--;
           /* try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            System.out.println("由" + Thread.currentThread().getName() + "计算count=:" + count);
        }

    }


}
