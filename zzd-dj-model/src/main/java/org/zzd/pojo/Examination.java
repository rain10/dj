package org.zzd.pojo;

import java.util.Date;

public class Examination {
    private Long id;

    private String title;

    private String manager;

    private Date managerTime;

    private Date startTime;

    private Date endTime;

    private Long ingTime;

    private Integer ing;

    private Integer enabled;

    private Integer type;

    private String examType;

    private Long paperId;

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getIngTime() {
        return ingTime;
    }

    public void setIngTime(Long ingTime) {
        this.ingTime = ingTime;
    }

    public Integer getIng() {
        return ing;
    }

    public void setIng(Integer ing) {
        this.ing = ing;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType == null ? null : examType.trim();
    }

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public Long getOrgid() {
        return orgid;
    }

    public void setOrgid(Long orgid) {
        this.orgid = orgid;
    }
}