package map;

import java.util.HashMap;

/**
 * @author wangqianlong
 * @create 2019-04-21 14:18
 */

public class Test {
    public static void main(String[] args) {
        int a = 47;
        System.out.println(((Integer) a).hashCode());


        User user = new User("wang", 18);
        User user1 = new User("wang", 18);
        HashMap<User, String> hashMap = new HashMap<>();
        hashMap.put(user, "hello user");
        System.out.println(hashMap.get(user1));


    }
}
