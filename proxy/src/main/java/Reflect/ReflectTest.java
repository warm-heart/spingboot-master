package Reflect;

/**
 * @author wangqianlong
 * @create 2018-09-26 11:23
 */
//获取类对象
public class ReflectTest {
    public static void main(String[] args) {


        //第一种方式获得Class对象
        Student student = new Student(); //产生Student.Class文件
        Class studentClass1 = student.getClass();  //获取Class对象
        System.out.println(studentClass1.getName());


        //第二种方式获取Class对象
        Class studentClass2 = Student.class;
        System.out.println(studentClass1 == studentClass2); //判断是否与第一种一样


        //第三种方式获取Class对象

        try {
            Class studentClass3 = Class.forName("Reflect.Student");  //类的绝对路径 包名+类名
            System.out.println(studentClass3 == studentClass2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }





        //获取方法
      /*  Class studentClass3 = Class.forName("Reflect.Student2");
        System.out.println("获取所有公有方法");
        studentClass3.getMethods();
        Method[] methods = studentClass3.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }



        System.out.println("获取所有方法 包括私有");
        methods = studentClass3.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m);
        }


        System.out.println("获取公有show1方法");
        methods = studentClass3.getDeclaredMethods();
       Method m = studentClass3.getMethod("show1", String.class);
            System.out.println(m);
            //实例化一个Student对象
        Object object = studentClass3.getConstructor().newInstance();
        //运行Student里的show1方法
        m.invoke(object,"王乾龙");




            Method m = studentClass3.getMethod("study");
        System.out.println(m);
        //实例化一个Student对象
        Object object1 = studentClass3.getConstructor().newInstance();
        //运行Student里的show1方法
        m.invoke(object1);
        */




        //获取属性
       /*
        System.out.println("----获取私有字段----");
        Field field = studentClass3.getDeclaredField("name");
        System.out.println(field);
        Object o = studentClass3.getConstructor().newInstance();
        field.setAccessible(true);  //暴力反射  解除私有限定
        field.set(o, "Cooper");
        Student2 student = (Student2) o;
        System.out.println("-----验证----" + student.getName());*/
    }
}
