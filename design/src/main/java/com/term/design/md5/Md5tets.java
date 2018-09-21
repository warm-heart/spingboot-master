package com.term.design.md5;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author wangqianlong
 * @create 2018-09-04 16:16
 */

public class Md5tets {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String str="123456";
        MD5 md5=new MD5();
        System.out.println(md5.EncodeByMd5(str));

        System.out.println(md5.check("123","202cb962ac59075b964b07152d234b70"));
    }

}
