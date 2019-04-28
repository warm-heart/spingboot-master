package com.example.moredatasorce.dao.master;

import com.example.moredatasorce.entity.Class;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class test1Test {
    @Autowired
    private Test1 Test1;

    @Test
    public void getclass1() {
        System.out.println(Test1.getclass1());
    }

    @Test
    public void save(){
        Class c = new Class();
        c.setClassId(1);
        c.setClassName("test1");
        Test1.save(c);
    }
}