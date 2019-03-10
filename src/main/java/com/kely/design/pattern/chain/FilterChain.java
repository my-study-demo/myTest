package com.kely.design.pattern.chain;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {

    private List<Filter> chain = new ArrayList<Filter>();

    public void addFilter(Filter filter) {
        chain.add(filter);
    }

    private int index = 0;

    @Override
    public void doFilter(Request request, Response response, Filter filterChian) {
        if (index == chain.size()) return;
        System.out.println("index="+index);
        Filter filter = chain.get(index++);
        filter.doFilter(request, response, filterChian);
    }
}