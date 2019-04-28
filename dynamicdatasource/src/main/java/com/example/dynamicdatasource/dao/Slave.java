package com.example.dynamicdatasource.dao;

import com.example.dynamicdatasource.entity.classes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangqianlong
 * @create 2018-10-14 18:46
 */
@Mapper
@Repository
public interface Slave {

    List<classes> getclass2();


    int save(classes c);
}
