package com.term.design.dao;

import com.term.design.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wangqianlong
 * @create 2018-07-31 14:10
 */
@Mapper
public interface PermissionDao {
    public List<Permission> findAll();

    public List<Permission> findByAdminUserId(int userId);
}
