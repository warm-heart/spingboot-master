package com.example.mybatis.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class departmentDaoTest  {

    @Autowired
    private departmentDao departmentDao;

    @Test
    public void selectcompany() {
       // System.out.println(departmentDao.selectdepartment(2));
    }
}