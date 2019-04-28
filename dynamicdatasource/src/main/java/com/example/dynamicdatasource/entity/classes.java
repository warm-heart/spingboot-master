package com.example.dynamicdatasource.entity;

/**
 * @author wangqianlong
 * @create 2018-10-14 18:56
 */

public class classes {
    private Integer classId;
    private String className;

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

    @Override
    public String toString() {
        return "classes{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                '}';
    }
}
