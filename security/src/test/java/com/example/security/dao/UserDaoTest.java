package com.example.security.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.security.SecurityApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;


public class UserDaoTest extends SecurityApplicationTests {
    @Autowired
    private UserDao userDao;

    @Autowired
    DruidDataSource druidDataSource;

    @Autowired
    private  DataSource dataSource;

    @Test
    public void getByMap() {
    }

    @Test
    public void getByRoleId() {
    }

    @Test
    public void getById() {
        userDao.getById(1);
        System.out.println(userDao.getById(1));
    }

    @Test
    public void create() {

    }

    @Test
    public void update() {
        System.out.println(dataSource.getClass());
    }

    @Test
    public void getByUserName() {
        System.out.println(userDao.getByUserName("cooper"));
    }

    @Test
    public void test() {
        System.out.println(druidDataSource.getClass());

    }

}