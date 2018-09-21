package com.example.mybatis.dao;

import com.example.mybatis.MybatisApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class StudentDaoTest extends MybatisApplicationTests {
    @Autowired
    private StudentDao studentDao;

    @Test
    public void selectStudent() {
        System.out.println(studentDao.selectStudent(1));
    }
}