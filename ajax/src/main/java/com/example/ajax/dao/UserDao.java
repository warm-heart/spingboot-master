package com.example.ajax.dao;

import com.example.ajax.entity.User;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

/**
 * @author wangqianlong
 * @create 2019-04-11 12:16
 */

@Mapper
public interface UserDao {

    List<User> users ();
}