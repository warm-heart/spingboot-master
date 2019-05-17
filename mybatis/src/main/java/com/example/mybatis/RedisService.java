package com.example.mybatis;

import com.example.mybatis.entity.Student;

import org.springframework.cache.annotation.CachePut;

import org.springframework.stereotype.Service;

/**
 * @author wangqianlong
 * @create 2019-05-17 20:50
 */

@Service
public class RedisService {
    //使用配置文件中的key生成策略

    @CachePut(value = "redis", keyGenerator = "keyGenerator")
    public Student student() {
        Student student = new Student();
        student.setStudentName("cooper");
        student.setStudentId(1);
        return student;
    }
}
