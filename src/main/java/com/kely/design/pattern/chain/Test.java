package com.kely.design.pattern.chain;

public class Test {
    public static void main(String[] args) {
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new HTMLFilter());
        filterChain.addFilter(new SensitiveFilter());
        Request request = new Request("<敏感词汇>");
        Response response = new Response();
        filterChain.doFilter(request, response, filterChain);
        System.out.println(request.req);
        System.out.println(response.resp);
    }
}