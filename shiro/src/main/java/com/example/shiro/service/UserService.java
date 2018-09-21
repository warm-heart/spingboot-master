package com.example.shiro.service;

import com.example.shiro.entity.User;


import java.util.List;
import java.util.Set;

/**
 * @author wangqianlong
 * @create 2018-07-26 11:53
 */

public interface UserService {

    User getUserByUserName(String userName);



    Set<String> findPermissionsByUserName(String userName);


}
