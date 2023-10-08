package com.example.program13;

public class UserModal {
    private String userName;
    private String email;
    private String phone;
    private String password;
    private String confrmPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfrmPassword() {
        return confrmPassword;
    }

    public void setConfrmPassword(String confrmPassword) {
        this.confrmPassword = confrmPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public UserModal(String username, String email, String phone, String password, String cnfrm_Password)
    {
        this.userName = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.confrmPassword = cnfrm_Password;
    }

}
