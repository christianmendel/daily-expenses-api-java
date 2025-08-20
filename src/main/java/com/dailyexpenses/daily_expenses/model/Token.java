package com.dailyexpenses.daily_expenses.model;

import java.util.Date;

public class Token {
    public Token() {};

    public Token(String userName, boolean b, Date now, Date validity, String accessToken, String refreshToken) {
        this.userName = userName;
        this.b = b;
        this.now = now;
        this.validity = validity;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    private String userName;
    private boolean b;
    private Date now;
    private Date validity;
    private String accessToken;
    private String refreshToken;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
