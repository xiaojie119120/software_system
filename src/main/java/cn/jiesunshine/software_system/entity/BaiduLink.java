package cn.jiesunshine.software_system.entity;

public class BaiduLink {
    private Integer bdId;

    private Integer bdSoftId;

    private String bdLink;

    private Integer bdType;

    public Integer getBdId() {
        return bdId;
    }

    public void setBdId(Integer bdId) {
        this.bdId = bdId;
    }

    public Integer getBdSoftId() {
        return bdSoftId;
    }

    public void setBdSoftId(Integer bdSoftId) {
        this.bdSoftId = bdSoftId;
    }

    public String getBdLink() {
        return bdLink;
    }

    public void setBdLink(String bdLink) {
        this.bdLink = bdLink == null ? null : bdLink.trim();
    }

    public Integer getBdType() {
        return bdType;
    }

    public void setBdType(Integer bdType) {
        this.bdType = bdType;
    }
}