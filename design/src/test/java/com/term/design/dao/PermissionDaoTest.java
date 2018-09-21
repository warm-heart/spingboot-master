package com.term.design.dao;

import com.term.design.DesignApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class PermissionDaoTest extends DesignApplicationTests {
    @Autowired
    private PermissionDao permissionDao;

    @Test
    public void findAll() {
    }

    @Test
    public void findByAdminUserId() {
        permissionDao.findByAdminUserId(1);
    }
}