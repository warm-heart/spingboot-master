package JdkCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author wangqianlong
 * @create 2019-04-10 15:27
 */

public class list {
    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("hao");
        list.add("ya");

        //Iterator遍历list集合
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}