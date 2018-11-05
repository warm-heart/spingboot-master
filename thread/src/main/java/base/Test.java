package base;

/**
 * @author wangqianlong
 * @create 2018-11-05 16:33
 */

public class Test {
    public static void main(String[] args) {
        //第一种方法运行
        Thread thread1 = new FristThread();
        thread1.run();
       //第二种方法
        Thread thread2 = new Thread(new SecondThread());
        thread2.run();
       //线程里面放入其他线程
       Thread thread3 = new ThreeThread(new FristThread());
       thread3.run();




    }
}
