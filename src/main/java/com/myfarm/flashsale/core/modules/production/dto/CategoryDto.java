package com.myfarm.flashsale.core.modules.production.dto;

import com.myfarm.flashsale.core.modules.common.validation.UUIDValueValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;

@ApiModel
public class CategoryDto {
    @ApiModelProperty(value = "分类ID。符合UUID格式。参考：http://www.uuid.online", required = true, example = "53355ca3-6428-455a-8d84-6e1a488dd76d")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    private String categoryId;

    @ApiModelProperty(value = "分类。分类规则：4到30位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,30}$<br> no need to fill when add, modify. Must fill when query", example = "category1234")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$", message = "分类只能包含字母，数字，下划线，减号，且长度在4-30之间")
    private String name;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
