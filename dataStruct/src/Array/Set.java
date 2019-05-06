package Array;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author wangqianlong
 * @create 2019-05-06 15:33
 */

public class Set {
    public static void main(String[] args) {

        Student student = new Student("wang");
        Student student1 = new Student("wang");
        Student student2 = new Student("da");

        java.util.Set<Student> set = new HashSet();
        set.add(student);
        set.add(student1);
        set.add(student2);
        set.add(student1);

        System.out.println(set.size());
        Iterator<Student> studentIterator = set.iterator();
        while (studentIterator.hasNext()){
            System.out.println(studentIterator.next());
        }
    }
}
