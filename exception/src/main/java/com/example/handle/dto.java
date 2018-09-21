package com.example.handle;




/**
 * @author wangqianlong
 * @create 2018-07-23 16:34
 */

public class dto {


    private int state;

    private String stateInfo;

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

    public dto(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    @Override
    public String toString() {
        return "dto{" +
                "state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                '}';
    }
}
