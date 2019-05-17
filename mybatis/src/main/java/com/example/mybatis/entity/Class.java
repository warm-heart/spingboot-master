package com.example.mybatis.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangqianlong
 * @create 2018-09-17 11:39
 */

public class Class  implements Serializable{
    private Integer classId;
    private String className;
    private List<Student> students;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", students=" + students +
                '}';
    }
}
