package com.example.mybatis.dao;



import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



public class StudentDaoTest extends MybatisApplicationTests {
    @Autowired
    private StudentDao studentDao;

    @Test
    public void selectStudent() {
        System.out.println(studentDao.selectStudentAndClass(1));
    }

}