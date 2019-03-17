package com.example.security.entity;

/**
 * @author wangqianlong
 * @create 2018-12-20 16:54
 */

public class Role implements Comparable<Role> {

    private Integer roleId;

    private String name;

    private Integer roleLevel;

    private String description;

    private String menuItems;

    @Override
    public int compareTo(Role o) {
        if(roleId == o.getRoleId()){
            return 0;
        }else if(roleId > o.getRoleId()){
            return 1;
        }else{
            return -1;
        }
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if(obj instanceof Role){
            if(this.roleId == ((Role)obj).getRoleId()){
                return true;
            }
        }
        return false;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(Integer roleLevel) {
        this.roleLevel = roleLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(String menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", name='" + name + '\'' +
                ", roleLevel=" + roleLevel +
                ", description='" + description + '\'' +
                ", menuItems='" + menuItems + '\'' +
                '}';
    }
}
