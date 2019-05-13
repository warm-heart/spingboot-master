package Array;

/**
 * @author wangqianlong
 * @create 2019-04-08 14:46
 */

public class ArrayTest {
    public static void main(String[] args) {
        Array<Object> arraye = new Array();
        for (int i = 0; i < 10; i++) {
            arraye.addLast(i);
        }
        System.out.println(arraye);

        arraye.add(1, new Student1("b"));
        System.out.println(arraye);

        arraye.add(1, new String("hello world "));
        System.out.println(arraye);


        arraye.removeElement(4);
        System.out.println(arraye);
        arraye.removeElement(5);
        System.out.println(arraye);
        arraye.removeElement(6);
        System.out.println(arraye);
        arraye.removeElement(7);
        System.out.println(arraye);


    }

}
