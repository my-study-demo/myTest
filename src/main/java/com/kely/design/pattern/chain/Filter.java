package com.kely.design.pattern.chain;

public interface Filter {
    void doFilter(Request request, Response response, Filter filterChain);
}