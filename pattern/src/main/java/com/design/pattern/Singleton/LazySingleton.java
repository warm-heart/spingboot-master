package com.design.pattern.Singleton;


/**
 * @author wangqianlong
 * @create 2019-07-26 9:17
 */

public class LazySingleton {


    private static LazySingleton lazySingleton;

    private LazySingleton() {
    }

    public static synchronized LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

}
