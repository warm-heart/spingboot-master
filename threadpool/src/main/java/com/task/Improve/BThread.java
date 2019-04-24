package com.task.Improve;



/**
 * @author wangqianlong
 * @create 2018-11-06 15:15
 */
//线程安全
public class BThread extends Thread {
    @Override
    public void run() {
        super.run();
        Service.post("b","bb");
    }
}
