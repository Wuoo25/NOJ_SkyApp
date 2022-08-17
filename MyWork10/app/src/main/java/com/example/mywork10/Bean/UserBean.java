package com.example.mywork10.Bean;

/**
 * 用户
 */
public class UserBean {

    private Integer user_id;
    private String user_Name;
    private String password;

    public UserBean(String user_Name, String password) {
        this.user_Name = user_Name;
        this.password = password;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
