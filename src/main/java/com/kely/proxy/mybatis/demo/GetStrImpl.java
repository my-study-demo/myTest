package com.kely.proxy.mybatis.demo;

public class GetStrImpl implements IGetStr {

    @Override
    public String getStrZero() {
        System.out.println("GetStrImpl.getStrZero");
        return "0";
    }

    @Override
    public String getStrOne() {
        return "1";
    }
}