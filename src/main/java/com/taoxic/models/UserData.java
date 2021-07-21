package com.taoxic.models;

public class UserData {

    private String username;

    private String password;

    private String easemobEmail;

    private String easemobName;

    public UserData(String username, String password, String easemobEmail, String easemobName) {
        this.username = username;
        this.password = password;
        this.easemobEmail = easemobEmail;
        this.easemobName = easemobName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEasemobEmail() {
        return easemobEmail;
    }

    public void setEasemobEmail(String easemobEmail) {
        this.easemobEmail = easemobEmail;
    }

    public String getEasemobName() {
        return easemobName;
    }

    public void setEasemobName(String easemobName) {
        this.easemobName = easemobName;
    }
}
