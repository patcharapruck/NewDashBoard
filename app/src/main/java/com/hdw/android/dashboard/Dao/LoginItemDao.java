package com.hdw.android.dashboard.Dao;

import com.hdw.android.dashboard.Dao.login.LoginObjectDao;

public class LoginItemDao {

    private Long statusCode;
    private String message;
    private LoginObjectDao object;

    public Long getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Long statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LoginObjectDao getObject() {
        return object;
    }

    public void setObject(LoginObjectDao object) {
        this.object = object;
    }
}
