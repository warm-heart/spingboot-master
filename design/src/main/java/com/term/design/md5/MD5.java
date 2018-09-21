package com.term.design.md5;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @author wangqianlong
 * @create 2018-09-04 16:11
 */

public class MD5 {


    public String EncodeByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        char[] chars = str.toCharArray();
        byte[] bytes = new byte[chars.length];
        for (int i = 0; i < chars.length; i++)
            bytes[i] = (byte) chars[i];
        byte[] md5bytes = messageDigest.digest(bytes);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5bytes.length; i++) {
            int val = ((int) md5bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));

        }
        return hexValue.toString();
        //返回16位MD5
        //return hexValue.toString().substring(8,24);
    }

    /*MD5加盐处理*/
    public String MD5Salt(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Random r =new Random();
        StringBuilder sb = new StringBuilder();
        return str;
    }

    public boolean check(String s, String s1) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if (EncodeByMd5(s).equals(s1))
            return true;
        else return false;
    }


}
