package com.example.redis.service;

import com.example.redis.entity.User;

/**
 * @author wangqianlong
 * @create 2018-07-29 17:04
 */
public interface UserService {

    /**
     * @param phone
     * @return
     */
    User findUserByPhone(String phone);


    /**
     * @param user
     * @return
     */
    int insert( User user);

    /**
     * @param name
     * @return
     */
    User findUserByName( String name);


}

