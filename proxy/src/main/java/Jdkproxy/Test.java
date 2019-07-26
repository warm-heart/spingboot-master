package Jdkproxy;


import StaticProxy.Moveable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


/**
 * @author wangqianlong
 * @create 2019-04-12 21:01
 */

public class Test {
    public static void main(String[] args) {
        Bus bmw = new Bmw();

        InvocationHandler in = new TimeHandle(bmw);
        Class<?> cls = bmw.getClass();

        Bus bus = (Bus) Proxy.newProxyInstance(cls.getClassLoader(),
                cls.getInterfaces(), in);

        String result = bus.move("宝马跑起来了");

        System.out.println(result);


        System.out.println(bus.go("参数1","参数2"));
    }
}

