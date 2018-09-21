package com.term.design.service;

import com.term.design.entity.User;

/**
 * @author wangqianlong
 * @create 2018-06-29 13:03
 */

public interface UserService {

    /**
     * @param phone
     * @return
     */
    User findUserByPhone( String phone);


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
