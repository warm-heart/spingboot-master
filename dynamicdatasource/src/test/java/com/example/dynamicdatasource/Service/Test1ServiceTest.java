package com.example.dynamicdatasource.Service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Test1ServiceTest {
    @Autowired
    private Test1Service test1Service;

    @Test
    public void find() {
        System.out.println(test1Service.find());
    }

    @Test
    public  void find2(){
        System.out.println(test1Service.find2());
    }
}