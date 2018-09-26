package Reflect;

/**
 * @author wangqianlong
 * @create 2018-09-26 11:22
 */

public class Student {
    private String name;

    public void study() {
        System.out.println("------学生------");
    }

    public void show1(String s){
        System.out.println("----调用了方法show1-----" +s);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
