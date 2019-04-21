package StaticProxy;

/**
 * @author wangqianlong
 * @create 2019-04-12 20:49
 */

public class CarTimeProxy implements Moveable {

    Car car;

    public CarTimeProxy(Car car) {
        this.car = car;
    }

    @Override
    public void move() {
        System.out.println("汽车开始行驶");
        long startTime = System.currentTimeMillis();
        car.move();
        long endtime = System.currentTimeMillis();
        System.out.println("汽车结束行驶： " + (endtime - startTime) + "毫秒");
    }
}
