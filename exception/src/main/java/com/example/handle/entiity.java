package com.example.handle;

/**
 * @author wangqianlong
 * @create 2019-03-08 19:51
 */

public class entiity {
    private String name="wang";
    private String id="123456";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "entiity{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
