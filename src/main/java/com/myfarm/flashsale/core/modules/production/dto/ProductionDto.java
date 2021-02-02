package com.myfarm.flashsale.core.modules.production.dto;

import com.myfarm.flashsale.core.modules.common.Constants;
import com.myfarm.flashsale.core.modules.common.validation.EnumValueValidator;
import com.myfarm.flashsale.core.modules.common.validation.UUIDValueValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;
import java.util.List;

@ApiModel
public class ProductionDto {
    @ApiModelProperty(value = "商品ID。符合UUID格式。参考：http://www.uuid.online <br> not fill when add. fill when modify or query", example = "d9a4d5d5-0c9a-4508-952c-091851285a54")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    private String productionId;//not fill when add. fill when modify or query

    @ApiModelProperty(value = "商品名称。商品名称规则：4到30位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,30}$",required = true, example = "production1234")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$", message = "商品名称只能包含字母，数字，下划线，减号，且长度在4-30之间")
    private String title;

    @ApiModelProperty(value = "商品图片", required = true)
    private List<String> picUrls;

    @ApiModelProperty(value = "分类ID。符合UUID格式。参考：http://www.uuid.online", required = true, example = "53355ca3-6428-455a-8d84-6e1a488dd76d")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    private String categoryId;  //always fill

    @ApiModelProperty(value = "分类。分类规则：4到30位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,30}$<br> no need to fill when add, modify. Must fill when query", example = "category1234")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$", message = "分类只能包含字母，数字，下划线，减号，且长度在4-30之间")
    private String categoryName;  // no need to fill when add, modify. Must fill when query

    @ApiModelProperty(value = "品牌ID。符合UUID格式。参考：http://www.uuid.online <br> fill if production has a band whenever do add, modify or query", example = "2010950c-99c6-440b-8c32-83d7051aa606")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    private String bandId;  //fill if production has a band when do add, modify or query

    @ApiModelProperty(value = "品牌。品牌规则：4到30位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,30}$<br> no need to fill whether production has a band or not when do add, modify. must fill if production has a band when query", example = "band1234")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$", message = "品牌只能包含字母，数字，下划线，减号，且长度在4-30之间")
    private String bandName; // no need to fill whether production has a band or not when do add, modify. must fill if production has a band when query

    @ApiModelProperty(value = "产地。产地规则：4到100位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,100}$", example = "shanxi_xian")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,100}$", message = "产地只能包含字母，数字，下划线，减号且长度在4-100")
    private String placeOrigin;

    @ApiModelProperty(value = "推荐理由。推荐理由规则：4到30位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,30}$", example = "very_good")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$", message = "推荐理由只能包含字母，数字，下划线，减号，且长度在4-30之间")
    private String recommendation;

    @ApiModelProperty(value = "保质期", example = "7days")
    private String shelfLife;

    @ApiModelProperty(value = "包装日期. format: yyyy.mm.dd", required = true, example = "2021.01.01")
    private String datePackage; //format: yyyy.mm.dd

    @ApiModelProperty(value = "预售时间. format: yyyy.mm.dd", required = true, example = "2021.01.12")
    private String datePresell; //format: yyyy.mm.dd

    @ApiModelProperty(value = "提货时间. format: yyyy.mm.dd", required = true, example = "2021.01.13")
    private String dateDelivery; //format: yyyy.mm.dd

    @ApiModelProperty(value = "价格", required = true, example = "1.1")
    private Double price;

    @ApiModelProperty(value = "原始价格",required = true, example = "2.3")
    private Double originalPrice;

    @ApiModelProperty(value = "规格", required = true, example = "1斤/份  正负0.1斤")
    private String unit;

    @ApiModelProperty(value = "排序",required = true, example = "1")
    @Range(min = 0, message = "排序最小值为0")
    private Integer rank;

    @ApiModelProperty(value = "库存",required = true, example = "0")
    @Range(min = 0, message = "库存最小值为0")
    private Integer stock;

    @ApiModelProperty(value = "销量。<br>no need to fill when add and modify. must fill when query", example = "500")
    private Integer salesVolume; // no need to fill when add and modify. must fill when query

    @ApiModelProperty(value = "上架状态。有效枚举值：New, On, Off. <br>not need to fill when add. fill what we read when modify and query")
    @EnumValueValidator(enumClass = Constants.ProductionStatus.class, message = "不是有效枚举值")
    private String statusOnShelf;  //not need to fill when add. fill what we read when modify and query

    @ApiModelProperty(value = "供应商ID。符合UUID格式。参考：http://www.uuid.online <br> always fill", required = true, example = "d9a4d5d5-0c9a-4508-952c-091851285a54")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    private String providerId; //always fill

    @ApiModelProperty(value = "供应商。供应商名称规则：4到30位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,30}$ <br> no need to fill when add, modify. Must fill when query", example = "provider1234")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$", message = "供应商名称只能包含字母，数字，下划线，减号，且长度在4-30之间")
    private String providerName; // no need to fill when add, modify. Must fill when query

    @ApiModelProperty(value = "供应商ID。符合UUID格式。参考：http://www.uuid.online <br> not need to fill when add and modify. fill when query", example = "d9a4d5d5-0c9a-4508-952c-091851285a54")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    private String auditId; // not need to fill when add and modify. fill when query

    @ApiModelProperty(value = "审核状态。有效枚举值：Awaiting， Approved，Rejected <br>not need to fill when add and modify. fill when query", example = "Approved")
    @EnumValueValidator(enumClass = Constants.AuditStatus.class, message = "不是有效枚举值")
    private String auditStatus; //not need to fill when add and modify. fill when query

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

    public List<String> getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(List<String> picUrls) {
        this.picUrls = picUrls;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getBandId() {
        return bandId;
    }

    public void setBandId(String bandId) {
        this.bandId = bandId;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getPlaceOrigin() {
        return placeOrigin;
    }

    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getDatePackage() {
        return datePackage;
    }

    public void setDatePackage(String datePackage) {
        this.datePackage = datePackage;
    }

    public String getDatePresell() {
        return datePresell;
    }

    public void setDatePresell(String datePresell) {
        this.datePresell = datePresell;
    }

    public String getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(String dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }

    public String getStatusOnShelf() {
        return statusOnShelf;
    }

    public void setStatusOnShelf(String statusOnShelf) {
        this.statusOnShelf = statusOnShelf;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getAuditId() {
        return auditId;
    }

    public void setAuditId(String auditId) {
        this.auditId = auditId;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }
}
