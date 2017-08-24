package org.zzd.pojo;

import java.util.Date;

public class Content {
    private Long id;

    private String title;

    private Integer recommend;

    private Integer type;

    private String other;

    private Integer enabled;

    private String manager;

    private Date manegerTime;

    private Long orgid;

    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public Date getManegerTime() {
        return manegerTime;
    }

    public void setManegerTime(Date manegerTime) {
        this.manegerTime = manegerTime;
    }

    public Long getOrgid() {
        return orgid;
    }

    public void setOrgid(Long orgid) {
        this.orgid = orgid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}