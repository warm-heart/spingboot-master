package com.term.design.dao;

import com.term.design.DesignApplicationTests;
import com.term.design.entity.SysUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
public class SysUserDaoTest extends DesignApplicationTests {

    @Autowired
    private SysUserDao sysUserDao;

    @Test
    public void finrByName() {

        SysUser sysUser=sysUserDao.findByName("root");
        System.out.println(sysUser.getUsername());
        System.out.println(sysUser.getRoles());
        System.out.println(sysUser.getAuthorities());
        System.out.println(sysUser.getPassword());
    }
}