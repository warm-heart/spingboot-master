package com.example.moredatasorce.dao.master;

import com.example.moredatasorce.entity.Class;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wangqianlong
 * @create 2018-10-14 18:46
 */
@Mapper
public interface test1 {

    List<Class> getclass1();
}
