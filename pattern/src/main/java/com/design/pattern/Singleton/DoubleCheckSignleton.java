package com.design.pattern.Singleton;

/**
 * @author wangqianlong
 * @create 2019-08-02 15:04
 */

public class DoubleCheckSignleton {

    private volatile static DoubleCheckSignleton signleton;

    public static DoubleCheckSignleton getSignleton() {

        if (signleton == null) {
            synchronized (DoubleCheckSignleton.class) {
                if (signleton == null) {
                    signleton = new DoubleCheckSignleton();
                }
            }
        }
        return signleton;
    }
}
