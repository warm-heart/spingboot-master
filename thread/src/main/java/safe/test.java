package safe;

/**
 * @author wangqianlong
 * @create 2019-04-18 21:48
 */

public class test {
    public static void main(String[] args) {
        SafeThread safeThread = new SafeThread();


        for (int i = 0; i <100 ; i++) {
            new Thread(safeThread,"线程"+i).start();
        }
    }
}
