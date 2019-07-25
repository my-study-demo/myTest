package com.kely.proxy.mybatis.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 用一个容器保存插件，这里用到了责任链模式
 * @author yangqh
 * @date 2019/7/25
 **/
public class InterceptorChain {

    /**
     * 放拦截器
     */
    private final List<Interceptor> interceptors = new ArrayList<Interceptor>();

    public Object pluginAll(Object target) {
        for (Interceptor interceptor : interceptors) {
            target = interceptor.plugin(target);
        }
        return target;
    }

    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }
}