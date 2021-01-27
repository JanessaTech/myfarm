package com.myfarm.flashsale.core.modules.site.dto;

public class SiteDto {
    private String siteId;
    private String name;
    private String telPhone;
    private String address;
    private String operatingStatus;
    private String sitePic;
    private String leader;
    private String comments;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOperatingStatus() {
        return operatingStatus;
    }

    public void setOperatingStatus(String operatingStatus) {
        this.operatingStatus = operatingStatus;
    }

    public String getSitePic() {
        return sitePic;
    }

    public void setSitePic(String sitePic) {
        this.sitePic = sitePic;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "SiteDto{" +
                "siteId='" + siteId + '\'' +
                ", name='" + name + '\'' +
                ", telPhone='" + telPhone + '\'' +
                ", address='" + address + '\'' +
                ", operatingStatus='" + operatingStatus + '\'' +
                ", sitePic='" + sitePic + '\'' +
                ", leader='" + leader + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
