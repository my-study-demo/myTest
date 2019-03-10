package com.kely.design.pattern.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by yangjiwang on 2018/10/28.
 */
public class JdkDbQueryHandler implements InvocationHandler {
    IDBQuery real = null;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JdkDbQueryHandler.invoke--1");
        if (real == null) {
            real = new OraclelQuery();
        }
        System.out.println("JdkDbQueryHandler.invoke--2");
        return real.query();
    }
}
