package com.example.mybatis.dao;

import com.example.mybatis.entity.company;
import com.example.mybatis.entity.department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangqianlong
 * @create 2018-09-16 10:37
 */
@Mapper
public interface departmentDao {


    department selectdepartment(Integer departmentId);
}
