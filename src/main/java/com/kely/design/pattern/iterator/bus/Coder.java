package com.kely.design.pattern.iterator.bus;

/**
 * @Description: 程序员
 * @Author yangqh
 * @Date 17:04 2019/1/15
 **/
public class Coder extends DoWorker {


    public Coder(String name) {
        super(name);
    }

    @Override
    protected void doWork(String name) {
        System.out.println(name + "撸码");
    }
}
