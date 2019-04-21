package Jdkproxy;

import StaticProxy.Car;
import StaticProxy.Moveable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


/**
 * @author wangqianlong
 * @create 2019-04-12 21:01
 */

public class Test {
    public static void main(String[] args) {
        Car car = new Car();

        InvocationHandler in = new TimeHandle(car);
        Class<?> cls = car.getClass();

        Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(),
                cls.getInterfaces(), in);

        m.move();
    }
}

