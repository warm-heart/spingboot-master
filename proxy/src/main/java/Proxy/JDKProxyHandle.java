package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wangqianlong
 */


/*代理处理器  通过这个来获取代理类*/
public class JDKProxyHandle implements InvocationHandler {
    private Object target=null;


    public Object JDKProxyHandle(Object target){
        this.target=target;
        /*
        * 第一个参数：类加载器
        *
        * 第二个参数：实现接口
        *
        * 第三个参数this指的就是：InvocationHandler  就是本类 implements的 InvocationHandler
        * 下面的public Object invoke(Object proxy, Method method, Object[] args) throws Throwable 是InvocationHandler
        * 的覆写类
         * */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }


    /**
     * @param proxy 被代理的对象
     * @param method 被代理对象的方法
     * @param args  方法参数
     * @return
     * @throws Throwable
     *
     * 动态代理可实现  AOP
     * sayhello() 方法只打印你好呀！
     * 在下面的逻辑中可以多打印一些信息
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑方法");
        System.out.println("在调度真实对象之前的服务");
        Object obj = method.invoke(target,args); //相当于sayhello方法
        System.out.println("在调度真实方法之后的服务");
        return obj;

    }
}
