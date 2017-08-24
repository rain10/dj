package org.zzd.pojo;

public class SysUser {
    private Long id;

    private String address;

    private String email;

    private Short enabled;

    private Short expired;

    private Short locked;

    private String password;

    private String phone;

    private String realname;

    private String username;

    private Short usertype;

    private Long orgid;

    private Long depid;

    private String prphone;

    private String propen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Short getEnabled() {
        return enabled;
    }

    public void setEnabled(Short enabled) {
        this.enabled = enabled;
    }

    public Short getExpired() {
        return expired;
    }

    public void setExpired(Short expired) {
        this.expired = expired;
    }

    public Short getLocked() {
        return locked;
    }

    public void setLocked(Short locked) {
        this.locked = locked;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Short getUsertype() {
        return usertype;
    }

    public void setUsertype(Short usertype) {
        this.usertype = usertype;
    }

    public Long getOrgid() {
        return orgid;
    }

    public void setOrgid(Long orgid) {
        this.orgid = orgid;
    }

    public Long getDepid() {
        return depid;
    }

    public void setDepid(Long depid) {
        this.depid = depid;
    }

    public String getPrphone() {
        return prphone;
    }

    public void setPrphone(String prphone) {
        this.prphone = prphone == null ? null : prphone.trim();
    }

    public String getPropen() {
        return propen;
    }

    public void setPropen(String propen) {
        this.propen = propen == null ? null : propen.trim();
    }
}