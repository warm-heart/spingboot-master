package com.example.mybatis.dao;


import com.example.mybatis.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDaoTest {
    @Autowired
    private StudentDao studentDao;


    @Test
    public void selectStudentAndClass() {
        System.out.println(studentDao.selectStudentAndClass(12));
    }

    @Test
    public void insertStudentAndClass() {
        studentDao.insertStudentAndClass(12, 2);
    }

    @Test
    public void dynamicSql() {
        studentDao.dynamicSql("student", 12);
    }

    @Test
    public void dynamicInsert() {
        Student student = new Student();
        student.setStudentName("warm-heart");
        studentDao.dynamicInsert("student", student);
    }

    @Test
    public void getGeneratedKeys() {

        Student student = new Student();
        student.setStudentName("warm-heart");
        studentDao.GetGeneratedKeys(student);
        System.out.println(student);
        System.out.println(student.getStudentId());

    }

    @Test
    public void removeStudent() {
        studentDao.removeStudent(12);
    }
}