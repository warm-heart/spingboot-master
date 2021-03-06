package com.example.mybatis.dao;


import com.example.mybatis.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * @author wangqianlong
 * @create 2018-09-17 11:43
 */
@Mapper
@Repository
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
    int insertStudentAndClass(@Param("studentId") Integer studentId,@Param("classId") Integer classId);


    /**
     * @param tableName  动态表名插入
     * @param studentId
     */
    void dynamicSql(@Param("tableName") String tableName,@Param("studentId") Integer studentId);

    /**
     * @param tableName 表名字
     * @param student    实体
     *                   动态表名插入数据
     */
    void dynamicInsert(@Param("tableName") String tableName,@Param("stu") Student student );


    /**
     * @param student 插入的实体
     * @return 影响的行数 并不是返回的主键
     */
    int GetGeneratedKeys(Student student);


    /**
     * @param studentId   学生ID
     * @return   影响的行数
     */
    int removeStudent(Integer studentId);
}
