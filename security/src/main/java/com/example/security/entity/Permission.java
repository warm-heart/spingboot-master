package com.example.security.entity;

/**
 * @author wangqianlong
 * @create 2018-12-20 16:28
 */

public class Permission {
    private Integer permissionId;

    private String name;

    private String permissionUrl;

    private String method;

    private String description;

    public Integer permissionId() {
        return permissionId;
    }

    public void setId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId=" + permissionId +
                ", name='" + name + '\'' +
                ", permissionUrl='" + permissionUrl + '\'' +
                ", method='" + method + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
