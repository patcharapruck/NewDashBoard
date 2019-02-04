package com.hdw.android.dashboard.Dao.login;

public class LoginObjectDao {

    private LoginAuthenticationDao authentication;

    public LoginAuthenticationDao getAuthentication() {
        return authentication;
    }

    public void setAuthentication(LoginAuthenticationDao authentication) {
        this.authentication = authentication;
    }
}
