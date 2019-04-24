package com.task.Improve;



/**
 * @author wangqianlong
 * @create 2018-11-06 15:00
 */

//线程安全
public class AThread extends Thread{


    @Override
    public void run() {
        super.run();
        Service.post("a","aa");

    }
}
