package com.example.redis.service.Impl;

import com.example.redis.dao.UserDao;
import com.example.redis.entity.User;

import com.example.redis.service.UserService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author wangqianlong
 * @create 2018-06-29 14:06
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserDao userDao;

    @Override
    @CachePut(value = "sSsdada",key = "#result.name")  //支持el  redis里的key为数据库中user id
    //@Cacheable(value = "sSsdada",key = "#123456")   value 为包名 key为数据的key
    public User findUserByPhone(String phone) {

       // try {
            User user =userDao.findUserByPhone(phone);

           /* if(user==null){
                throw new UserException("没有此用户");
            }
            return user;
        }catch (UserException e1){
            throw e1;
        }*/
           return user;

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
