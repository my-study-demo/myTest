package com.kely.web.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by YMO on 2018/9/5.
 */
public class T1 {

    @ApiModelProperty(value = "类一", required = true)
    private T2 t2;

    public T2 getT2() {
        return t2;
    }

    public void setT2(T2 t2) {
        this.t2 = t2;
    }
}
