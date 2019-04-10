package org.example.entity;

/**
 * @author wangqianlong
 * @create 2019-04-08 20:02
 */

public class UserBean {
    private String account;
    private String password;
    private String sex;
    private String birthday;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


    @Override
    public String toString() {
        return "UserBean{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
