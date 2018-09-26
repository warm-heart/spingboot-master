package Proxy;

/**
 * @author wangqianlong
 * @create 2018-09-26 10:27
 */

public class ProTest {
    public static void main(String[] args) {
        JDKProxyHandle jdkProxyHandle = new JDKProxyHandle();
        Hello proxy = (Hello) jdkProxyHandle.JDKProxyHandle(new HelloImpl());
        proxy.sayHello();
    }
}
