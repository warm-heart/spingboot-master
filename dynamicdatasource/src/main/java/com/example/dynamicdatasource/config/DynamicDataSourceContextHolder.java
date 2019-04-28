package com.example.dynamicdatasource.config;

import com.example.dynamicdatasource.Enum.DataSourceKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author wangqianlong
 * @create 2019-04-28 19:46
 */

public class DynamicDataSourceContextHolder {
    Logger logger = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);

    private static final ThreadLocal<DataSourceKey> currentDatesource = new ThreadLocal<>();


    /**
     * 清除当前数据源
     */
    public static void clear() {
        currentDatesource.remove();
    }

    /**
     * 获取当前使用的数据源
     * @return 当前使用数据源的ID
     */
    public static DataSourceKey get() {
        return currentDatesource.get();
    }

    /**
     * 设置当前使用的数据源
     *
     * @param value 需要设置的数据源ID
     */
    public static void set(DataSourceKey value) {
        currentDatesource.set(value);
    }


}

