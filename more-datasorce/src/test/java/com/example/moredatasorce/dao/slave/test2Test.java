package com.example.moredatasorce.dao.slave;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class test2Test {
    @Autowired
    private test2 test2;

    @Test
    public void getclass2() {
        System.out.println("成了成了成了成了成了成了");
        System.out.println(test2.getclass2());
    }
}