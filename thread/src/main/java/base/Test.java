package base;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangqianlong
 * @create 2018-11-05 16:33
 */

public class Test {
    public static void main(String[] args) throws InterruptedException {
        //第一种方法运行
        Thread thread1 = new FristThread();
        synchronized (thread1){
            thread1.run();
            thread1.start();
            thread1.wait();

            System.out.println("你好的呀");
        }





     /*  //第二种方法
        Thread thread2 = new Thread(new SecondThread());
        thread2.run();
       //线程里面放入其他线程
       Thread thread3 = new ThreeThread(new FristThread());
       thread3.run();*/



       /* SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间

        Thread.sleep(1000);
        // Thread.yield();
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间*/


    }
}
