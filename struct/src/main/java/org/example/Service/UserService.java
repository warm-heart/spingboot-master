package org.example.Service;

import org.example.entity.UserBean;

/**
 * @author wangqianlong
 * @create 2019-04-08 20:05
 */

public class UserService {
    public boolean login(UserBean loginUser) {
        if (loginUser.getAccount().equals(loginUser.getPassword()))
            return true;
        return false;
    }

    public boolean register(UserBean userBean) {

        if (userBean.getAccount().equals(userBean.getPassword()))
            return true;
        return false;
    }
}
