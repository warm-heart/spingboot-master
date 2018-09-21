package com.example.jpa.dao;

import com.example.jpa.JpaApplicationTests;
import com.example.jpa.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest extends JpaApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void test() {
        List<User> users = userDao.findAll();
        System.out.println(users);
    }
    @Test
    public  void findByUserName(){
       /* User user=userDao.findByName("Cooper");
        System.out.println(user);*/

    }


}