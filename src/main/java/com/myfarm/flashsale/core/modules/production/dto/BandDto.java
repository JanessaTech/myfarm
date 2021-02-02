package com.myfarm.flashsale.core.modules.production.dto;

import com.myfarm.flashsale.core.modules.common.validation.UUIDValueValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;

@ApiModel
public class BandDto {
    @ApiModelProperty(value = "品牌ID。符合UUID格式。参考：http://www.uuid.online", example = "2010950c-99c6-440b-8c32-83d7051aa606")
    @UUIDValueValidator(message = "不是有效的UUID格式。参考：http://www.uuid.online/")
    private String bandId;

    @ApiModelProperty(value = "品牌。品牌规则：4到30位（字母，数字，下划线，减号）。正则表达式：^[a-zA-Z0-9_-]{4,30}$", required = true, example = "band1234")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$", message = "品牌只能包含字母，数字，下划线，减号，且长度在4-30之间")
    private String name;

    public String getBandId() {
        return bandId;
    }

    public void setBandId(String bandId) {
        this.bandId = bandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
