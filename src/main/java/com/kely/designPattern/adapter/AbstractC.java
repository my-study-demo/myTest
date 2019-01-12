package com.kely.designPattern.adapter;

/**
 * @Description: 适配器
 * @Author yangqh
 * @Date 17:06 2019/1/11
 **/
public abstract class AbstractC implements IB,IA {

    void execute() {
        System.out.println("execute begin...");
        a1();
        b1();
        System.out.println("execute end...");
    }
}
