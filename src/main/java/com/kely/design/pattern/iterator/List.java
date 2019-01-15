package com.kely.design.pattern.iterator;

/**
 * @Description: 容器角色(Aggregate)
 * @Author yangqh
 * @Date 16:40 2019/1/15
 * @Param
 * @Return
 **/
interface List {

    void add(Object obj);

    Object get(int index);

    Iterator iterator();

    int getSize();
}