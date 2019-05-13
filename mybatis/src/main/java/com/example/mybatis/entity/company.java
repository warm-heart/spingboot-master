package com.example.mybatis.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangqianlong
 * @create 2018-09-16 8:38
 */

public class Company implements Serializable {
    private Long companyId;
    private String companyName;
    private List<Department> departments;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", departments=" + departments +
                '}';
    }
}
