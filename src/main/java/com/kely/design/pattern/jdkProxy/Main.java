package com.kely.design.pattern.jdkProxy;

/**
 * @author yangqh
 * @date 2019/3/10
 **/
public class Main {
    public static void main(String[] args) {
        String rtn = JdkProxy.createJdkProxy().query();
        System.out.println(rtn);
    }
}
