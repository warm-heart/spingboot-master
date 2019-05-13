package com.example.mybatis.dao;

import com.example.mybatis.entity.Department;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wangqianlong
 * @create 2018-09-16 10:37
 */
@Mapper
public interface departmentDao {


    Department selectdepartment(Integer departmentId);
}
