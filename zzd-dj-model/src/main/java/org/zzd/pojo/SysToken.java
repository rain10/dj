package org.zzd.pojo;

import java.util.Date;

public class SysToken {
    private Long userId;

    private String token;

    private Date tokenTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Date getTokenTime() {
        return tokenTime;
    }

    public void setTokenTime(Date tokenTime) {
        this.tokenTime = tokenTime;
    }
}