package com.example.mongo.dao;

import com.example.mongo.entity.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class accountDaoTest {
    @Autowired
    private accountDao accountDao;

    @Test
    public void save() {
        Account account = new Account();
        account.setAccountId(1);
        account.setAccountName("test1");
        account.setAccountPassword("123456");
        accountDao.save(account);
    }
}