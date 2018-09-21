package com.term.design.dao;

import com.term.design.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author wangqianlong
 * @create 2018-07-29 10:30
 */
@Mapper
public interface SysUserDao {
    SysUser findByName(String username);

    SysUser getById(Integer id);
}
