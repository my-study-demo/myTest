package com.kely.design.pattern.adapter;

/**
 * @Description: 适配器具体的功能实现
 * @Author yangqh
 * @Date 17:06 2019/1/11
 **/
public class CImpl extends AbstractC {
    @Override
    public void a1() {
        System.out.println("CImpl-a1-do");
    }

    @Override
    public void b1() {
        System.out.println("CImpl-b1-do");
    }
}
