package com.example.ajax.dao;

import com.example.ajax.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * @author wangqianlong
 * @create 2019-04-11 12:16
 */

@Mapper
@Repository
public interface UserDao {

    List<User> users ();

    Integer insert(User user);

    Integer update(User user);

    User getUserByUserId(String userId);
}
