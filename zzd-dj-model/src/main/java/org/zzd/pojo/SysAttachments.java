package org.zzd.pojo;

import java.util.Date;

public class SysAttachments {
    private Long id;

    private String attachmentsType;

    private String servicePath;

    private String appName;

    private String uploadAppName;

    private String attachmentPath;

    private String attachmentName;

    private String attachmentSize;

    private String attachmentFormat;

    private Date opTime;

    private Integer enabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttachmentsType() {
        return attachmentsType;
    }

    public void setAttachmentsType(String attachmentsType) {
        this.attachmentsType = attachmentsType == null ? null : attachmentsType.trim();
    }

    public String getServicePath() {
        return servicePath;
    }

    public void setServicePath(String servicePath) {
        this.servicePath = servicePath == null ? null : servicePath.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getUploadAppName() {
        return uploadAppName;
    }

    public void setUploadAppName(String uploadAppName) {
        this.uploadAppName = uploadAppName == null ? null : uploadAppName.trim();
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath == null ? null : attachmentPath.trim();
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName == null ? null : attachmentName.trim();
    }

    public String getAttachmentSize() {
        return attachmentSize;
    }

    public void setAttachmentSize(String attachmentSize) {
        this.attachmentSize = attachmentSize == null ? null : attachmentSize.trim();
    }

    public String getAttachmentFormat() {
        return attachmentFormat;
    }

    public void setAttachmentFormat(String attachmentFormat) {
        this.attachmentFormat = attachmentFormat == null ? null : attachmentFormat.trim();
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
}