package Array;


/**
 * @author wangqianlong
 * @create 2019-04-03 15:16
 */

public class arr {
    public static void main(String[] args) {
        Array array = new Array(20);
        for (int i = 0; i < 10; i++) {
            array.add(i,i);
        }
        array.add(2,19);
        System.out.println(array);
    }
}

