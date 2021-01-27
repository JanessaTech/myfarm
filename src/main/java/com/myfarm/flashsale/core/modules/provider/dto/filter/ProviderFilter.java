package com.myfarm.flashsale.core.modules.provider.dto.filter;

import com.myfarm.flashsale.core.modules.common.Constants;

public class ProviderFilter {
    private String providerId;
    private String name;
    private String telPhone;
    private String operatingStatus;
    private String orderBy = "provider_id";
    private String order = Constants.Order.ASC.getCode();

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
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

    public String getOperatingStatus() {
        return operatingStatus;
    }

    public void setOperatingStatus(String operatingStatus) {
        this.operatingStatus = operatingStatus;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "ProviderFilter{" +
                "providerId='" + providerId + '\'' +
                ", name='" + name + '\'' +
                ", telPhone='" + telPhone + '\'' +
                ", operatingStatus='" + operatingStatus + '\'' +
                ", orderBy='" + orderBy + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}
