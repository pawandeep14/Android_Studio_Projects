package com.example.karan.myapplication;

public class newuser {

    String emailid;
    String password;
    String role;


    public newuser(String emailid, String password, String role) {
        this.emailid = emailid;
        this.password = password;
        this.role = role;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
