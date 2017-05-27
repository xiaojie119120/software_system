package cn.jiesunshine.software_system.entity;

import java.util.Date;

public class Software {
    private Integer softId;

    private Integer softUserId;

    private Integer softGroupId;

    private String softName;

    private String softAbstract;

    private Long softSize;

    private String softVersion;

    private Date softDate;

    private String softOs;

    private Integer softDownloadVolume;

    private String softFileLink;

    private String softIconLink;

    private Date softCreateTime;

    private String softCreateIp;

    private Date preUpdateTime;

    private String preUpdateIp;

    private String softDetails;

    public Integer getSoftId() {
        return softId;
    }

    public void setSoftId(Integer softId) {
        this.softId = softId;
    }

    public Integer getSoftUserId() {
        return softUserId;
    }

    public void setSoftUserId(Integer softUserId) {
        this.softUserId = softUserId;
    }

    public Integer getSoftGroupId() {
        return softGroupId;
    }

    public void setSoftGroupId(Integer softGroupId) {
        this.softGroupId = softGroupId;
    }

    public String getSoftName() {
        return softName;
    }

    public void setSoftName(String softName) {
        this.softName = softName == null ? null : softName.trim();
    }

    public String getSoftAbstract() {
        return softAbstract;
    }

    public void setSoftAbstract(String softAbstract) {
        this.softAbstract = softAbstract == null ? null : softAbstract.trim();
    }

    public Long getSoftSize() {
        return softSize;
    }

    public void setSoftSize(Long softSize) {
        this.softSize = softSize;
    }

    public String getSoftVersion() {
        return softVersion;
    }

    public void setSoftVersion(String softVersion) {
        this.softVersion = softVersion == null ? null : softVersion.trim();
    }

    public Date getSoftDate() {
        return softDate;
    }

    public void setSoftDate(Date softDate) {
        this.softDate = softDate;
    }

    public String getSoftOs() {
        return softOs;
    }

    public void setSoftOs(String softOs) {
        this.softOs = softOs == null ? null : softOs.trim();
    }

    public Integer getSoftDownloadVolume() {
        return softDownloadVolume;
    }

    public void setSoftDownloadVolume(Integer softDownloadVolume) {
        this.softDownloadVolume = softDownloadVolume;
    }

    public String getSoftFileLink() {
        return softFileLink;
    }

    public void setSoftFileLink(String softFileLink) {
        this.softFileLink = softFileLink == null ? null : softFileLink.trim();
    }

    public String getSoftIconLink() {
        return softIconLink;
    }

    public void setSoftIconLink(String softIconLink) {
        this.softIconLink = softIconLink == null ? null : softIconLink.trim();
    }

    public Date getSoftCreateTime() {
        return softCreateTime;
    }

    public void setSoftCreateTime(Date softCreateTime) {
        this.softCreateTime = softCreateTime;
    }

    public String getSoftCreateIp() {
        return softCreateIp;
    }

    public void setSoftCreateIp(String softCreateIp) {
        this.softCreateIp = softCreateIp == null ? null : softCreateIp.trim();
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

    public String getSoftDetails() {
        return softDetails;
    }

    public void setSoftDetails(String softDetails) {
        this.softDetails = softDetails == null ? null : softDetails.trim();
    }
}