package com.example.moredatasorce.dao.slave;

import com.example.moredatasorce.entity.Class;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class test2Test {
    @Autowired
    private Test2 Test2;

    @Test
    public void getclass2() {
        System.out.println("成了成了成了成了成了成了");
        System.out.println(Test2.getclass2());
    }

    @Test
    public void save(){
        Class c = new Class();
        c.setClassId(1);
        c.setClassName("test2");
        Test2.save(c);
    }
}