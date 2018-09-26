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
    }
}
