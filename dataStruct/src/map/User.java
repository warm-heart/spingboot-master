package map;

/**
 * @author wangqianlong
 * @create 2019-04-21 14:46
 */

public class User {

    private String name;
    // static String age ="18";
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public int hashCode() {
        int B = 31;
        int hash = 0;
        hash = hash * B + name.hashCode();
        hash = hash * B + age;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User another = (User) obj;
        return this.name.equals(another.name) && this.age == another.age;
    }
}
