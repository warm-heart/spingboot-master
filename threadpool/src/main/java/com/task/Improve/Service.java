package com.task.Improve;

/**
 * @author wangqianlong
 * @create 2018-11-06 15:01
 */
//线程安全业务类
public class Service {
    private static String usernameRef;
    private static String passwordRef;

    //不加synchronized关键字线程并非安全的
   synchronized public static void post(String username,String password)   {
        usernameRef=username;
        if (username.equals("a")){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        passwordRef=password;
        System.out.println("username=" +usernameRef+" password="+password);
    }
}
