package base;

/**
 * @author wangqianlong
 * @create 2018-11-05 16:34
 */

public class SecondThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("It is Second Thread");
    }
}
