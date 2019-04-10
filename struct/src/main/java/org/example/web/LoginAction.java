package org.example.web;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.example.Service.UserService;
import org.example.entity.UserBean;

import java.util.Map;

/**
 * @author wangqianlong
 * @create 2018-10-17 10:07
 */

public class LoginAction extends ActionSupport {
    private UserBean loginUser;

    public UserBean getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(UserBean loginUser) {
        this.loginUser = loginUser;
    }

    public String login() throws Exception {
        ActionContext context=ActionContext.getContext();
       Map request= (Map) context.get("request");
        System.out.println(request.get("loginUser.account"));


        UserService userService = new UserService();
        if (userService.login(loginUser)) {
            this.addActionError("登陆成功");
            return "success";
        } else this.addActionError("用户名或密码错误,请重新输入");
        return "fail";


    }

    public String register() throws Exception {
        UserService userService = new UserService();
        if (userService.register(loginUser))
            return "success";
        return "fail";
    }

    @Override
    public void validate() {
        String account = loginUser.getAccount();
        String pwd = loginUser.getPassword();
        if (account == null || account.equals("")) {
            this.addFieldError("loginUser.account", "请输入你的用户名");
        }
        if (pwd == null || pwd.equals("")) {
            this.addFieldError("loginUser.password", "请输入你的密码");
        }
    }
}
