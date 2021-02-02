package com.myfarm.flashsale.core.modules.production.dto.filter;

import com.myfarm.flashsale.core.modules.common.Constants;
import com.myfarm.flashsale.core.modules.common.validation.EnumValueValidator;
import com.myfarm.flashsale.core.modules.common.validation.UUIDValueValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;

@ApiModel
public class ProductionFilter {
    @ApiModelProperty(value = "商品ID。符合UUID格式。参考：http://www.uuid.online", example = "d9a4d5d5-0c9a-4508-952c-091851285a54")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    private String productionId;

    @ApiModelProperty(value = "商品名称。后端针对该字段进行模糊匹配。商品名称规则：4到30位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,30}$", example = "production1234")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$", message = "商品名称只能包含字母，数字，下划线，减号，且长度在4-30之间")
    private String title;

    @ApiModelProperty(value = "供应商。后端针对该字段进行模糊匹配。供应商名称规则：4到30位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,30}$", example = "provider1234")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$", message = "供应商名称只能包含字母，数字，下划线，减号，且长度在4-30之间")
    private String providerName;

    @ApiModelProperty(value = "分类ID。符合UUID格式。参考：http://www.uuid.online", example = "53355ca3-6428-455a-8d84-6e1a488dd76d")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    private String categoryId;

    @ApiModelProperty(value = "品牌ID。符合UUID格式。参考：http://www.uuid.online", example = "2010950c-99c6-440b-8c32-83d7051aa606")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    private String bandId;

    @ApiModelProperty(value = "上架状态。有效枚举值：New, On, Off", example = "On")
    @EnumValueValidator(enumClass = Constants.ProductionStatus.class, message = "不是枚举有效值")
    private String statusOnShelf = Constants.ProductionStatus.On.getStatus();

    @ApiModelProperty(value = "审核状态。有效枚举值：Awaiting, Approved, Rejected", example = "Approved")
    @EnumValueValidator(enumClass = Constants.AuditStatus.class, message = "不是枚举有效值")
    private String auditStatus = Constants.AuditStatus.Approved.getStatus();

    @ApiModelProperty(value = "待排序的列名。默认为键值列", example = "production_id")
    private String orderBy = "production_id";

    @ApiModelProperty(value = "升序还是降序排序。有效枚举值：ASC, DESC", example = "ASC")
    @EnumValueValidator(enumClass = Constants.Order.class, message = "不是枚举有效值")
    private String order = Constants.Order.ASC.getCode();

    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getBandId() {
        return bandId;
    }

    public void setBandId(String bandId) {
        this.bandId = bandId;
    }

    public String getStatusOnShelf() {
        return statusOnShelf;
    }

    public void setStatusOnShelf(String statusOnShelf) {
        this.statusOnShelf = statusOnShelf;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
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
}
