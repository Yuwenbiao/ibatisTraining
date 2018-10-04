package com.example.demo.entity;

import java.io.Serializable;

/**
 * 用户信息
 *
 * @author yuwb@corp.21cn.com
 * @date 2018/10/4 11:34
 */
public class User implements Serializable {
    private static final long serialVersionUID = 9195742902504046489L;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户手机
     */
    private String mobile;
    /**
     * 用户邮箱
     */
    private String email;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [email=" + email + ", mobile=" + mobile + ", password="
                + password + ", userId=" + userId + ", userName=" + userName
                + "]";
    }
}
