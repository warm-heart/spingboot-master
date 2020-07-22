package com.example.redis.dao;


import com.example.redis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author wangqianlong
 * @create 2018-07-29 17:00
 */
@Mapper
@Repository
public interface UserDao {


    /**
     * @param phone
     * @return
     */
    User findUserByPhone(@Param("phone") String phone);


    /**
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * @param name 姓名
     * @return
     */
    User findUserByName( String name);
}

