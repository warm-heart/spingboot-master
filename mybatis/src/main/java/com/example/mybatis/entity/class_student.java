package com.example.mybatis.entity;



/**
 * @author wangqianlong
 * @create 2018-09-17 11:42
 */

public class class_student {
    private Class cllass;
    private Student student;

    public Class getCllass() {
        return cllass;
    }

    public void setCllass(Class cllass) {
        this.cllass = cllass;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "class_student{" +
                "cllass=" + cllass +
                ", student=" + student +
                '}';
    }
}
