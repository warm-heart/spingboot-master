package com.example.shiro.service.Impl;

import com.example.shiro.dao.UserMapper;
import com.example.shiro.entity.User;
import com.example.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


/**
 * @author wangqianlong
 * @create 2018-07-26 12:02
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;





    @Override
    public User getUserByUserName(String userName) {
        return userMapper.findUserByUserName(userName);
    }



    @Override
    public Set<String> findPermissionsByUserName(String userName) {
        return new HashSet<String>(userMapper.findPermissionsByUserName(userName));
    }


}
