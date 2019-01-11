package com.kely.web.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by YMO on 2018/9/5.
 */
public class JsonResult<T> {

    @ApiModelProperty(value = "状态", required = true)
    private boolean status;

    @ApiModelProperty(value = "消息", required = true)
    private String message;

    @ApiModelProperty(value = "返回信息", required = true)
    private T data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
