package com.myfarm.flashsale.core.modules.audit.dto.filter;

import com.myfarm.flashsale.core.modules.common.Constants;
import com.myfarm.flashsale.core.modules.common.validation.EnumValueValidator;
import com.myfarm.flashsale.core.modules.common.validation.UUIDValueValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;

@ApiModel
public class AuditFilter {
    @ApiModelProperty(value = "审核人。审核人规则：4到16位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,16}$", required = true, example = "shenHe_123")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$", message = "审核人只能包含字母，数字，下划线，减号，且长度在4-16之间")
    private String auditor;

    @ApiModelProperty(value = "审核商品名称。后端针对该字段进行模糊匹配。审核商品名称规则：4到30位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,30}$", example = "production1234")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$", message = "审核商品名称只能包含字母，数字，下划线，减号，且长度在4-30之间")
    private String production_title;

    @ApiModelProperty(value = "工号。0-2147483647", example = "8")
    @Range(min = 0, max = 2147483647, message = "有效工号范围：0-2147483647")
    private Integer employeeId;

    @ApiModelProperty(value = "商品ID。符合UUID格式。参考：http://www.uuid.online", example = "d9a4d5d5-0c9a-4508-952c-091851285a54")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    private String productionId;

    @ApiModelProperty(value = "审核状态。有效枚举值：Awaiting, Approved, Rejected", example = "Approved")
    @EnumValueValidator(enumClass = Constants.AuditStatus.class, message = "不是枚举有效值")
    private String status;

    @ApiModelProperty(value = "待排序的列名。默认为键值列", example = "audit_id")
    private String orderBy = "audit_id";

    @ApiModelProperty(value = "升序还是降序排序。有效枚举值：ASC, DESC", example = "ASC")
    @EnumValueValidator(enumClass = Constants.Order.class, message = "不是枚举有效值")
    private String order = Constants.Order.ASC.getCode();

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

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getProduction_title() {
        return production_title;
    }

    public void setProduction_title(String production_title) {
        this.production_title = production_title;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
