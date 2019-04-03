package Reflect;



import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
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
        //InputStream in = ConfigTest.class.getResourceAsStream("config.properties");  //本包下
        InputStream in = ConfigTest.class.getResourceAsStream("/Proxy/config.properties");  //跨包
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



                   //获取方法
      /*  Class clazz1 = Class.forName("Reflect.Student");
        System.out.println("获取所有公有方法");
        clazz1.getMethods();
        Method[] methods = clazz1.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }



        System.out.println("获取所有方法 包括私有");
        methods = clazz1.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m);
        }


        System.out.println("获取公有show1方法");
        methods = clazz1.getDeclaredMethods();
       Method m = clazz1.getMethod("show1", String.class);
            System.out.println(m);
            //实例化一个Student对象
        Object object = clazz1.getConstructor().newInstance();
        //运行Student里的show1方法
        m.invoke(object,"王乾龙");  */




                     //获取属性
       /* Class clazz3 = Class.forName("Reflect.Student");
        System.out.println("----获取私有字段----");
        Field field = clazz3.getDeclaredField("name");
        System.out.println(field);
        Object o = clazz3.getConstructor().newInstance();
        field.setAccessible(true);  //暴力反射  解除私有限定
        field.set(o, "Cooper");
        Student student = (Student) o;
        System.out.println("-----验证----" + student.getName());*/


    }
}
