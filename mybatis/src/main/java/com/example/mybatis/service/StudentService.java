package com.example.mybatis.service;

import com.example.mybatis.dao.StudentDao;
import com.example.mybatis.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangqianlong
 * @create 2019-07-04 12:23
 */

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    @Transactional
    public void GetGeneratedKeys(Student student) {
        Integer i = studentDao.GetGeneratedKeys(student);
        throw new RuntimeException();
    }


}
