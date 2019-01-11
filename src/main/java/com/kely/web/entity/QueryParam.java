package com.kely.web.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by YMO on 2018/9/5.
 */
public class QueryParam {

    @ApiModelProperty(value = "关键字", required = true)
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
