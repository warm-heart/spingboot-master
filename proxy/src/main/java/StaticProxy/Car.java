package StaticProxy;

import java.util.Random;

/**
 * @author wangqianlong
 * @create 2019-04-12 20:31
 */

public class Car implements Moveable {
    @Override
    public void move() {
        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("汽车行驶中");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
