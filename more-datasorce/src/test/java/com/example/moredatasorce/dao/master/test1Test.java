package com.example.moredatasorce.dao.master;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class test1Test {
    @Autowired
    private test1 test1;

    @Test
    public void getclass1() {
        System.out.println(test1.getclass1());
    }
}