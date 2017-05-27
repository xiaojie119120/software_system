package cn.jiesunshine.software_system.entity;

import java.util.Date;

public class User {
    private Integer id;

    private String name;

    private String password;

    private String email;

    private String picLink;

    private Integer softwareCount;

    private Integer type;

    private Date regTime;

    private String regIp;

    private Date preLoginTime;

    private String preLoginIp;

    private Date preUpdateTime;

    private String preUpdateIp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPicLink() {
        return picLink;
    }

    public void setPicLink(String picLink) {
        this.picLink = picLink == null ? null : picLink.trim();
    }

    public Integer getSoftwareCount() {
        return softwareCount;
    }

    public void setSoftwareCount(Integer softwareCount) {
        this.softwareCount = softwareCount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp == null ? null : regIp.trim();
    }

    public Date getPreLoginTime() {
        return preLoginTime;
    }

    public void setPreLoginTime(Date preLoginTime) {
        this.preLoginTime = preLoginTime;
    }

    public String getPreLoginIp() {
        return preLoginIp;
    }

    public void setPreLoginIp(String preLoginIp) {
        this.preLoginIp = preLoginIp == null ? null : preLoginIp.trim();
    }

    public Date getPreUpdateTime() {
        return preUpdateTime;
    }

    public void setPreUpdateTime(Date preUpdateTime) {
        this.preUpdateTime = preUpdateTime;
    }

    public String getPreUpdateIp() {
        return preUpdateIp;
    }

    public void setPreUpdateIp(String preUpdateIp) {
        this.preUpdateIp = preUpdateIp == null ? null : preUpdateIp.trim();
    }
}