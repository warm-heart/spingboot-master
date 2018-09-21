package com.example.redis.service.Impl;

import com.example.redis.dao.UserDao;
import com.example.redis.entity.User;
import com.example.redis.exception.UserException;
import com.example.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author wangqianlong
 * @create 2018-06-29 14:06
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Cacheable(value = "user-key")
    public User findUserByPhone(String phone) {

        try {
            User user =userDao.findUserByPhone(phone);
            if(user==null){
                throw new UserException("没有此用户");
            }
            return user;
        }catch (UserException e1){
            throw e1;
        }

    }

    @Override
    public int insert(User user) {
        userDao.insert(user);
        return 1;
    }

    @Override
    @Cacheable(value = "user-key")
    public User findUserByName(String name) {
        User user=userDao.findUserByName(name);
        return user;
    }


}
