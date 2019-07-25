package Array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author wangqianlong
 * @create 2019-07-25 17:41
 */

public class Tets {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        stringList.set(2,"xiugaihou");

        Iterator<String> iterator = stringList.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("b".equals(item)) {
                iterator.remove();

            }
        }
        System.out.println(stringList);
    }
}
