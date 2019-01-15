package com.kely.design.pattern.adapter;

/**
 * @Description: 测试
 * @Author yangqh
 * @Date 17:07 2019/1/11
 **/
public class Test {

    public static void main(String[] args) {
        AbstractC abstractC = new CImpl();
        abstractC.execute();
    }
}
