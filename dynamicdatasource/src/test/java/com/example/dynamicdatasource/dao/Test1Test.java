package com.example.dynamicdatasource.dao;

import com.example.dynamicdatasource.DynamicdatasourceApplicationTests;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class Test1Test extends DynamicdatasourceApplicationTests {
    Logger logger = LoggerFactory.getLogger(Test1Test.class);

    @Autowired
    private Master master;

    @Test
    public void getclass1() {
        System.out.println(master.getclass1());
    }

    @Test
    public void save() {
    }
}