package com.example.mybatis.dao;


import com.example.mybatis.entity.Company;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wangqianlong
 * @create 2018-09-16 20:05
 */
@Mapper

public interface companyDao {

   Company selectcompany(Integer companyId);
}
