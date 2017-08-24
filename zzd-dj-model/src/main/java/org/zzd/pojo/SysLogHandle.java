package org.zzd.pojo;

import java.util.Date;

public class SysLogHandle {
    private Long logId;

    private Date logTime;

    private String logUser;

    private String logUrl;

    private String logData;

    private String logSuccess;

    private String logException;

    private String logIp;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getLogUser() {
        return logUser;
    }

    public void setLogUser(String logUser) {
        this.logUser = logUser == null ? null : logUser.trim();
    }

    public String getLogUrl() {
        return logUrl;
    }

    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl == null ? null : logUrl.trim();
    }

    public String getLogData() {
        return logData;
    }

    public void setLogData(String logData) {
        this.logData = logData == null ? null : logData.trim();
    }

    public String getLogSuccess() {
        return logSuccess;
    }

    public void setLogSuccess(String logSuccess) {
        this.logSuccess = logSuccess == null ? null : logSuccess.trim();
    }

    public String getLogException() {
        return logException;
    }

    public void setLogException(String logException) {
        this.logException = logException == null ? null : logException.trim();
    }

    public String getLogIp() {
        return logIp;
    }

    public void setLogIp(String logIp) {
        this.logIp = logIp == null ? null : logIp.trim();
    }
}