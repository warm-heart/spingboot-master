package com.example.mybatis.entity;

import java.util.List;

/**
 * @author wangqianlong
 * @create 2018-09-16 8:38
 */

public class company {
    private Integer companyId;
    private String companyName;
    private List<department> departments;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", departments=" + departments +
                '}';
    }
}
