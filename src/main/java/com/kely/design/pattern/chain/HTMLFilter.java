package com.kely.design.pattern.chain;

public class HTMLFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, Filter filterChain) {
        System.out.println("htmlfilter");
        request.req = request.req.replace("<", "[");
        request.req = request.req.replace(">", "]");
        System.out.println(request.req);
        filterChain.doFilter(request, response, filterChain);
        response.resp += "-----HTMLFilter";
    }
}