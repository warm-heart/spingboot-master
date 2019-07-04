package com.example.mybatis.service;

import com.example.mybatis.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void getGeneratedKeys() {
        Student student = new Student();
        student.setStudentName("mr ");
        studentService.GetGeneratedKeys(student);
    }
}