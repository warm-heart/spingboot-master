package annotation;

import java.lang.reflect.Field;


/**
 * @author wangqianlong
 * @create 2019-04-17 17:04
 */

public class test {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName("annotation.Student2");

        // Class c = Student2.class;
        Field[] fields = c.getDeclaredFields();

        for (Field field : fields) {
            boolean fielHasAnnotation = field.isAnnotationPresent(Value.class);
            if (fielHasAnnotation == true) {
                Value value = field.getAnnotation(Value.class);
                System.out.println(field.getName());
                System.out.println(value.values());
            }
        }
    }
}
