package Array;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author wangqianlong
 * @create 2019-05-06 15:33
 */

public class Set {
    public static void main(String[] args) {

        Student1 student = new Student1("wang");
        Student1 student11 = new Student1("wang");
        Student1 student12 = new Student1("da");

        java.util.Set<Student1> set = new HashSet();
        set.add(student);
        set.add(student11);
        set.add(student12);
        set.add(student11);

        System.out.println(set.size());
        Iterator<Student1> studentIterator = set.iterator();
        while (studentIterator.hasNext()){
            System.out.println(studentIterator.next());
        }
    }
}
