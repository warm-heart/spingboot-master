package com.term.design.dto;

import com.term.design.entity.User;
import com.term.design.enums.ConfigEnum;

/**
 * @author wangqianlong
 * @create 2018-07-23 16:34
 */

public class Userdto {
    private int state;

    private String stateInfo;

    private User user;

    public Userdto(ConfigEnum configEnum) {
        this.stateInfo = configEnum.getStateInfo();
        this.state = configEnum.getState();
    }

    public Userdto(ConfigEnum configEnum, User user) {
        this.user = user;
        this.state = configEnum.getState();
        this.stateInfo = configEnum.getStateInfo();
    }

    @Override
    public String toString() {
        return "Userdto{" +
                "state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                '}';
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
