package com.kely.design.pattern.jdkProxy;

import java.lang.reflect.Proxy;

/**
 * Created by yangjiwang on 2018/10/28.
 */
public class JdkProxy {
    public static IDBQuery createJdkProxy() {
        System.out.println("JdkProxy.createJdkProxy--1");
        IDBQuery jdkProxy = (IDBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{IDBQuery.class},new JdkDbQueryHandler());
        System.out.println("JdkProxy.createJdkProxy--2");
        return jdkProxy;
    }
}
