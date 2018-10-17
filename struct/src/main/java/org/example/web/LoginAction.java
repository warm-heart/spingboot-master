package org.example.web;


import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangqianlong
 * @create 2018-10-17 10:07
 */

public class LoginAction   {
   /* private String useName;
    private String password;

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }*/


    public String da() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String useName = request.getParameter("useName");
        String password = request.getParameter("password");
       if(useName.equals(password)){
           return "success";
       }
       else return "error";
    }
}
