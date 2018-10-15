package com.example.mongo.dao;

import com.example.mongo.entity.Account;
import org.springframework.stereotype.Repository;

/**
 * @author wangqianlong
 * @create 2018-10-15 8:49
 */

public interface accountDao {
    void save(Account account);
}
