package com.extraannotations.anno_app.model;

import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Configuration
public class LoginCredentials {
    private String userName;
    @JsonProperty("key")
    private String password;
    @JsonIgnore
    private String mail;

    public LoginCredentials() {
    }

    public LoginCredentials(String userName, String password, String mail) {
        this.userName = userName;
        this.password = password;
        this.mail = mail;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
