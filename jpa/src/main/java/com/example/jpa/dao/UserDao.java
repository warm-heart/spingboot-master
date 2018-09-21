package com.example.jpa.dao;

import com.example.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wangqianlong
 * @create 2018-06-21 18:34
 */
public interface UserDao extends JpaRepository<User,Long> {
    /*自定义方法 By（name）后面要和数据库一致  理论上不区分大小写*/
    User findByName(String name);


}
