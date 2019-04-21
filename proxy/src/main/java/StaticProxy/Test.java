package StaticProxy;

/**
 * @author wangqianlong
 * @create 2019-04-12 20:43
 */

public class Test {
    public static void main(String[] args) {
        Car car =new Car();

        CarTimeProxy carTimeProxy = new CarTimeProxy(car);
        carTimeProxy.move();


    }
}
