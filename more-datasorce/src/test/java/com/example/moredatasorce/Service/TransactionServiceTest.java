package com.example.moredatasorce.Service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionServiceTest  {
    @Autowired
    private TransactionService transactionService;

    @Test
    public void test1() {
        transactionService.test1();
    }

    @Test
    public void test2() {
        transactionService.test2();
    }
}