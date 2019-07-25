package com.kely.proxy.mybatis.demo;

/**
 * @author yangqh
 * @date 2019/7/25
 * @see {https://mp.weixin.qq.com/s?__biz=MzIxMzk3Mjg5MQ%3D%3D&mid=2247484432&idx=1&sn=7d12b7cc978f13816509a695d0a82a2f&chksm=97afe6e4a0d86ff24d7491b28768c421df00f69c50240e8e7005480cf03068e76125c21b100e&mpshare=1&scene=23&srcid=&sharer_sharetime=1563845702027&shar=}
 **/
public class Main {

    public static void main(String[] args) {

        // 配置插件
        InterceptorChain interceptorChain = new InterceptorChain();
        interceptorChain.addInterceptor(new FirstInterceptor());
        interceptorChain.addInterceptor(new SecondInterceptor());

        // 获得代理对象
        IGetStr getStr = new GetStrImpl();
        getStr = (IGetStr) interceptorChain.pluginAll(getStr);

        String result = getStr.getStrZero();
        System.out.println(result);

        result = getStr.getStrOne();
        System.out.println(result);
    }
}