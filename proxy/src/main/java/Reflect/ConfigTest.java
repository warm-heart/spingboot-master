package Reflect;



import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author wangqianlong
 * @create 2018-09-26 11:59
 */

public class ConfigTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException,
            IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
                          //读取配置文件并加载类
        Properties properties = new Properties();
        //InputStream in = ConfigTest.class.getResourceAsStream("SpringConfig.properties");  //本包下
        InputStream in = ConfigTest.class.getResourceAsStream("/StaticProxy/config.properties");  //跨包
        properties.load(in);


        System.out.println(properties.getProperty("className"));
        System.out.println(properties.getProperty("methodName"));

        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        Class clazz = Class.forName(className);
        Object object = clazz.newInstance();
        Method method = clazz.getMethod(methodName);
        method.invoke(object);
        in.close();

    }
}
