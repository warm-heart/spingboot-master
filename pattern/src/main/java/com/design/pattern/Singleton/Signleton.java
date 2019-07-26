package com.design.pattern.Singleton;


/**
 * @author wangqianlong
 * @create 2019-07-26 9:17
 */

public class Signleton {


    private static Signleton signleton;

    private Signleton() {
    }

    public static synchronized Signleton getInstance() {
        if (signleton == null) {
            signleton = new Signleton();
        }
        return signleton;
    }


}
