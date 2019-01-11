package com.kely.web.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by YMO on 2018/9/5.
 */
public class T2 {

    @ApiModelProperty(value = "姓名", required = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
