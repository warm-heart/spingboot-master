package com.term.design.entity;

/**
 * @author wangqianlong
 * @create 2018-07-29 10:12
 */

public class SysRole {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
