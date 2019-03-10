package com.kely.design.pattern.jdkProxy;

/**
 * Created by yangjiwang on 2018/10/28.
 */
public class OraclelQuery implements IDBQuery {
    @Override
    public String query() {
        return "oracle";
    }
}
