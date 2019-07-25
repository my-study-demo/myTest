package com.kely.proxy.mybatis.demo;

/**
 * 第二个插件和第一个插件类似
 * @author yangqh
 * @date 2019/7/25
 **/
public class SecondInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) {
        try {
            System.out.println("SecondInterceptor.intercept");
            return "plugin2 " + invocation.proceed() + " plugin2";
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }
}