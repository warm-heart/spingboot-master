package com.example.moredatasorce.Service;

import com.example.moredatasorce.dao.master.Test1;
import com.example.moredatasorce.dao.slave.Test2;
import com.example.moredatasorce.entity.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangqianlong
 * @create 2019-04-28 12:57
 */
@Service
public class TransactionService {

    @Autowired
    private Test1 test1;
    @Autowired
    private Test2 test2;


    @Transactional
    public void test1() {
        Class c = new Class();
        c.setClassId(1);
        c.setClassName("test1");
        test1.save(c);
        throw new RuntimeException("test1事务回滚测试");

    }


    @Transactional(value = "slaveTransactionManager")
    public void test2() {
        Class c = new Class();
        c.setClassId(1);
        c.setClassName("test2");
        test2.save(c);
        throw new RuntimeException("test2事务回滚测试");

    }
}
