package org.zzd.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class SysRegion {
    private Long id;

    private Long pid;

    private String name;

    private BigDecimal sort;

    private Short enabled;

    private String operator;

    private Date opTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public BigDecimal getSort() {
        return sort;
    }

    public void setSort(BigDecimal sort) {
        this.sort = sort;
    }

    public Short getEnabled() {
        return enabled;
    }

    public void setEnabled(Short enabled) {
        this.enabled = enabled;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }
}