package com.example.mongo.dao;

import com.example.mongo.entity.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author wangqianlong
 * @create 2018-10-15 8:51
 */
@Component

public class accountDaoImpl implements accountDao {

  @Autowired
  private  MongoTemplate mongoTemplate;
    @Override
    public void save(Account account) {

        mongoTemplate.save(account,"mycol");

    }
}
