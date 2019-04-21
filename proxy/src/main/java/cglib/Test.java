package cglib;

/**
 * @author wangqianlong
 * @create 2019-04-12 21:25
 */

public class Test {
    public static void main(String[] args) {

        CglibProxy proxy = new CglibProxy();
        Train train= (Train) proxy.getProxy(Train.class);
        train.move();
    }
}
