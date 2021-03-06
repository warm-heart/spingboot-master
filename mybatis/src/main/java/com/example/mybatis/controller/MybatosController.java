package com.example.mybatis.controller;

import com.example.mybatis.dao.companyDao;
import com.example.mybatis.dao.departmentDao;
import com.example.mybatis.entity.Company;
import com.example.mybatis.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangqianlong
 * @create 2018-09-17 8:01
 */
@RestController
public class MybatosController {

    @Autowired
    private companyDao companyDao;

    @Autowired
    private departmentDao departmentDao;

    @RequestMapping(value = "/company")
    public Company test1() {
        return companyDao.selectcompany(1);
    }

    @RequestMapping(value = "/department")
    public Department test2() {
        return departmentDao.selectdepartment(2);
    }

}
