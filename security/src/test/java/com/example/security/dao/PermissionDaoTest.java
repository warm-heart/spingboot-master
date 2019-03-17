package com.example.security.dao;

import com.example.security.SecurityApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.ws.Action;

import static org.junit.Assert.*;

public class PermissionDaoTest extends SecurityApplicationTests {
    @Autowired
    private PermissionDao permissionDao;

    @Test
    public void getByMap() {
    }

    @Test
    public void getById() {
    }

    @Test
    public void create() {
    }

    @Test
    public void update() {
    }

    @Test
    public void getByUserId() {
        System.out.println(permissionDao.getByUserId(1));
    }
}