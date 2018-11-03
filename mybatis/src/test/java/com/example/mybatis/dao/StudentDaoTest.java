package com.example.mybatis.dao;

import com.example.mybatis.MybatisApplicationTests;
import com.example.mybatis.entity.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class StudentDaoTest extends MybatisApplicationTests {
    @Autowired
    private StudentDao studentDao;

    @Test
    public void selectStudent() {
        System.out.println(studentDao.selectStudentAndClass(1));
    }

    @Test
    public void In() {

        System.out.println("成了成了成了成了成了成了成了成了");
        Student student = new Student();
        student.setStudentName("胖子7号");6
        studentDao.GetGeneratedKeys(student);
        System.out.println("主键值为："+student.getStudentId());

    }
}