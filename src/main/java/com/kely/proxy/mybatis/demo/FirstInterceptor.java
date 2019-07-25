package com.kely.proxy.mybatis.demo;

/**
 * 写第一个插件
 * @author yangqh
 * @date 2019/7/25
 **/
public class FirstInterceptor implements Interceptor {


    /**
     * 执行拦截逻辑的方法
     */
    @Override
    public Object intercept(Invocation invocation) {
        try {
            System.out.println("FirstInterceptor.intercept");
            return "plugin1 " + invocation.proceed() + " plugin1";
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 为原先的类生成代理对象
     */
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }
}