package com.example.mybatis.dao;

import com.example.mybatis.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wangqianlong
 * @create 2018-09-17 11:43
 */
@Mapper
public interface StudentDao {

    /**
     * @param studentId
     * @return  查找学生对应的班级
     */
    Student selectStudentAndClass(Integer studentId);

    /**
     * @param studentId
     * @param classId
     * @return 插入中间表
     */
    int insertStudentAndClass(@Param("studentId") String studentId,@Param("classId") String classId);


    /**
     * @param tableName  动态表名插入
     * @param studentId
     */
    void dynamicSql(@Param("tableName") String tableName,@Param("studentId") String studentId);

    /**
     * @param tableName 表名字
     * @param student    实体
     *                   动态表名插入数据
     */
    void dynamicInsert(@Param("tableName") String tableName,@Param("stu") Student student );




    void GetGeneratedKeys(Student student);
}
