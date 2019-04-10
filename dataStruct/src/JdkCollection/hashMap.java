package JdkCollection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author wangqianlong
 * @create 2019-04-10 15:13
 */

public class hashMap {
    public static void main(String[] args) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("1", "a");
        hashMap.put("2", "b");
        hashMap.put("3", "c");
        hashMap.put("4", "d");
        hashMap.put("5", "e");

       /* //alibaba 开发手册建议 entrySet 方式遍历map
        System.out.println("one :Start");
        for (Map.Entry entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }


        // Iterator keySet 遍历  iterator.next()是map中key
        Iterator iterator = hashMap.keySet().iterator();
        System.out.println("two :Start");
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println("key是： " + key + " value是： " + hashMap.get(key));

        }

        // Iterator entrySet 遍历  iterator.next()是map中key
        Iterator iterator1 = hashMap.entrySet().iterator();
        System.out.println("three :Start");
        while (iterator1.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator1.next();
            System.out.println("key是： " + entry.getKey() + " value是： " + entry.getValue());
        }*/


       hashMap.forEach((k,v)->{
           System.out.println(v);
       });
    }


}
