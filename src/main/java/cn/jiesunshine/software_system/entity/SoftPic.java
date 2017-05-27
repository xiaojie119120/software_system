package cn.jiesunshine.software_system.entity;

import java.util.Date;

public class SoftPic {
    private Integer picId;

    private Integer picSoftId;

    private Integer picUserId;

    private String picLink = "";

    private Long picSize = 0l;

    private String picType = "jpg";

    private Date picTime;

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public Integer getPicSoftId() {
        return picSoftId;
    }

    public void setPicSoftId(Integer picSoftId) {
        this.picSoftId = picSoftId;
    }

    public Integer getPicUserId() {
        return picUserId;
    }

    public void setPicUserId(Integer picUserId) {
        this.picUserId = picUserId;
    }

    public String getPicLink() {
        return picLink;
    }

    public void setPicLink(String picLink) {
        this.picLink = picLink == null ? null : picLink.trim();
    }

    public Long getPicSize() {
        return picSize;
    }

    public void setPicSize(Long picSize) {
        this.picSize = picSize;
    }

    public String getPicType() {
        return picType;
    }

    public void setPicType(String picType) {
        this.picType = picType == null ? null : picType.trim();
    }

    public Date getPicTime() {
        return picTime;
    }

    public void setPicTime(Date picTime) {
        this.picTime = picTime;
    }
}