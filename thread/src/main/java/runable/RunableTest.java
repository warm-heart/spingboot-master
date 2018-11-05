package runable;

/**
 * @author wangqianlong
 * @create 2018-11-05 16:50
 */

public class RunableTest {
    public static void main(String[] args) {

        Thread thread1 =new Thread(new FristRunable());
        thread1.run();
    }
}
