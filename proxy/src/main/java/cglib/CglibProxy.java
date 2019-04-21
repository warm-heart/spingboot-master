package cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


import java.lang.reflect.Method;

/**
 * @author wangqianlong
 * @create 2019-04-12 21:17
 */

public class CglibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz){
        //设置创建子类的类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     * @param obj 目标类实例
     * @param method 目标方法的反射对象
     * @param args  方法的参数列表
     * @param methodProxy  代理类实例
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy methodProxy) throws Throwable {

        System.out.println("开始了");

       ///代理类调用父类方法 也就是调用父类的move方法
        methodProxy.invokeSuper(obj,args);
        return null;

    }
}
