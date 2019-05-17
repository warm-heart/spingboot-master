package com.example.mybatis.entity;


import java.io.Serializable;
import java.util.List;

/**
 * @author wangqianlong
 * @create 2018-09-17 11:23
 */

public class Student implements Serializable {

    private static final long serialVersionUID = -3325138597898786918L;
    private Integer studentId;
    private String studentName;
    private List<Class> classes;


    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", classes=" + classes +
                '}';
    }
}
