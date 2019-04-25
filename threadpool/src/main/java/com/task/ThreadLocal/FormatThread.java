package com.task.ThreadLocal;


import java.text.ParseException;

/**
 * @author wangqianlong
 * @create 2019-04-24 16:14
 */

public class FormatThread implements Runnable {
    Format format;

    public FormatThread(Format format) {
        this.format = format;
    }

    @Override
    public void run() {
        try {
            System.out.println(format.parse("2019-4-24 09:09:08"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
