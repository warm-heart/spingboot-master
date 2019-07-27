package Reflect;

import java.lang.reflect.Field;

/**
 * @author wangqianlong
 * @create 2019-07-25 20:10
 */

public class ReflectReleaseImmutable {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        String str = "abc";
        System.out.println(str);

        Field field = String.class.getDeclaredField("value");
        field.setAccessible(true);

        char[] value = (char[])field.get(str);
        value[0] = '1';
        value[1] = '2';
       // value[2] = '3';

        System.out.println(str);
    }
}
