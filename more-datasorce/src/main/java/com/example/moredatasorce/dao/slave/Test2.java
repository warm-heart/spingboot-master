package com.example.moredatasorce.dao.slave;

import com.example.moredatasorce.entity.Class;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangqianlong
 * @create 2018-10-14 18:46
 */
@Mapper
@Repository
public interface Test2 {

    List<Class> getclass2();


    int save(Class c);
}
