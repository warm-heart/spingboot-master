package com.term.design.enums;

/**
 * @author wangqianlong
 * @create 2018-07-23 16:08
 */

public enum  ConfigEnum {

    SUCCESS(0,"成功"),

    ERROR(1,"失败");

    private int state;

    private String stateInfo;

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }



    ConfigEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static ConfigEnum stateOf(int index){
        for (ConfigEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
