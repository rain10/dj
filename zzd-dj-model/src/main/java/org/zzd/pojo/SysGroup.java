package org.zzd.pojo;

public class SysGroup {
    private Long id;

    private String name;

    private String secretary;

    private String address;

    private Integer type;

    private String phone;

    private Long orgid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSecretary() {
        return secretary;
    }

    public void setSecretary(String secretary) {
        this.secretary = secretary == null ? null : secretary.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Long getOrgid() {
        return orgid;
    }

    public void setOrgid(Long orgid) {
        this.orgid = orgid;
    }
}