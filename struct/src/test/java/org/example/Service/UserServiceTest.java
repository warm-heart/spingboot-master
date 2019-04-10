package org.example.Service;

import org.example.entity.UserBean;
import org.junit.Test;



public class UserServiceTest {

    @Test
    public void login() {
        UserService userService = new UserService();
        UserBean userBean = new UserBean();
        userBean.setAccount("da");
        userBean.setPassword("da");
        System.out.println(userService.login(userBean));
    }
}