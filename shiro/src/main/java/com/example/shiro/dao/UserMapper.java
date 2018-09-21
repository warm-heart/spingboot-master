package com.example.shiro.dao;




import com.example.shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wangqianlong
 * @create 2018-07-26 13:43
 */
@Mapper
public interface UserMapper {

    User findUserByUserName(String userName);



    List<String> findPermissionsByUserName(String userName);
}
