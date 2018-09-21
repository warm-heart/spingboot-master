package com.example.mybatis.dao;

import com.example.mybatis.entity.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wangqianlong
 * @create 2018-09-17 11:43
 */
@Mapper
public interface StudentDao {

    Student selectStudent(Integer studentId);
}
