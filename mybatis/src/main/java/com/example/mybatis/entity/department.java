package com.example.mybatis.entity;

/**
 * @author wangqianlong
 * @create 2018-09-16 8:39
 */

public class department {
    private Integer departmentId;
    private  String departmentName;
    private company company;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public com.example.mybatis.entity.company getCompany() {
        return company;
    }

    public void setCompany(com.example.mybatis.entity.company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", company=" + company +
                '}';
    }
}
