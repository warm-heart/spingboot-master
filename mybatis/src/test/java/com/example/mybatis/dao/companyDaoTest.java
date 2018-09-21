package com.example.mybatis.dao;

import com.example.mybatis.MybatisApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class companyDaoTest extends MybatisApplicationTests {

    @Autowired
    private companyDao companyDao;

    @Test
    public void departmentlist() {

        System.out.println( companyDao.selectcompany(1));
    }
}