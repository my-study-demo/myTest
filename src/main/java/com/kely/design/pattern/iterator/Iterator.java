package com.kely.design.pattern.iterator;

/**
 * @Description: 迭代器角色(Iterator)
 * @Author yangqh
 * @Date 16:38 2019/1/15
 * @Param
 * @Return
 **/
public interface Iterator {

    boolean hasNext();

    Object next();
}