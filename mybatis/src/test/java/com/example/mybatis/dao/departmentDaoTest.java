package com.example.mybatis.dao;

import com.example.mybatis.MybatisApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class departmentDaoTest extends MybatisApplicationTests {

    @Autowired
    private departmentDao departmentDao;

    @Test
    public void selectcompany() {

        System.out.println( departmentDao.selectdepartment(2));
    }
}