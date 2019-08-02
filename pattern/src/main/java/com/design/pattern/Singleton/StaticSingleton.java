package com.design.pattern.Singleton;

/**
 * @author wangqianlong
 * @create 2019-08-02 15:09
 */

public class StaticSingleton {

    private static StaticSingleton staticSingleton = new StaticSingleton();

    private StaticSingleton() {
    }

    public static StaticSingleton getStaticSingleton() {
        return staticSingleton;
    }
}
