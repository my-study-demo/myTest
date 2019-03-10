package com.kely.design.pattern.chain;

public class SensitiveFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, Filter filterChain) {
        System.out.println("sensitivefilter");
        request.req = request.req.replace("敏感", "*");
        filterChain.doFilter(request, response, filterChain);
        System.out.println(request.req);
        response.resp += "----SensitiveFilter";
    }
}