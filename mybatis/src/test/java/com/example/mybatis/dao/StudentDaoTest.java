package com.example.mybatis.dao;


import com.example.mybatis.RedisService;
import com.example.mybatis.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDaoTest {

    @Autowired
    private RedisService redisService;
    //需要在配置中声明@Bean(name = "redisTemplate")，不然乱码或者直接使用下面那种注入
    @Autowired
    private RedisTemplate redisTemplate;

   /* @Autowired
    private RedisTemplate<String, Object> redisTemplate;*/

    @Autowired
    private StudentDao studentDao;


    @Test
    public void selectStudentAndClass() {
        System.out.println(studentDao.selectStudentAndClass(12));
    }

    @Test
    public void insertStudentAndClass() {
        studentDao.insertStudentAndClass(12, 2);
    }

    @Test
    public void dynamicSql() {
        studentDao.dynamicSql("student", 12);
    }

    @Test
    public void dynamicInsert() {
        Student student = new Student();
        student.setStudentName("warm-heart");
        studentDao.dynamicInsert("student", student);
    }

    @Test
    public void getGeneratedKeys() {

        Student student = new Student();
        student.setStudentName("warm-heart");
        studentDao.GetGeneratedKeys(student);
        System.out.println(student);
        System.out.println(student.getStudentId());

    }

    @Test
    public void removeStudent() {
        studentDao.removeStudent(12);
    }


    @Test
    public void redis() {
       // redisTemplate.opsForValue().set("test", new Student());
        redisService.student();
    }
}