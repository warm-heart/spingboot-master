package com.example.ajax.FormController;

import org.springframework.stereotype.Service;

/**
 * @author wangqianlong
 * @create 2020-04-26 16:39
 */
@Service
public class Test {

    {
        System.out.println("普通代码块");
    }

    static {
        System.out.println("静态代码块");
    }

}
