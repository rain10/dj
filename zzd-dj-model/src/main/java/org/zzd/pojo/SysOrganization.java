package org.zzd.pojo;

public class SysOrganization {
    private Long id;

    private String number;

    private String name;

    private Short enabled;

    private Long pid;

    private Long city;

    private Short grade;

    private String mark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getEnabled() {
        return enabled;
    }

    public void setEnabled(Short enabled) {
        this.enabled = enabled;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }

    public Short getGrade() {
        return grade;
    }

    public void setGrade(Short grade) {
        this.grade = grade;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}