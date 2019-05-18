package com.example.server;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wangqianlong
 * @create 2019-05-18 10:48
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -4036187144374236223L;
    private String userName;
    private String password;

}
