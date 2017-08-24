package org.zzd.pojo;

import java.util.Date;

public class ExaminationPaper {
    private Long id;

    private String title;

    private String manager;

    private Date managerTime;

    private Integer enabled;

    private Integer ing;

    private Long orgid;

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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    public Date getManagerTime() {
        return managerTime;
    }

    public void setManagerTime(Date managerTime) {
        this.managerTime = managerTime;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Integer getIng() {
        return ing;
    }

    public void setIng(Integer ing) {
        this.ing = ing;
    }

    public Long getOrgid() {
        return orgid;
    }

    public void setOrgid(Long orgid) {
        this.orgid = orgid;
    }
}