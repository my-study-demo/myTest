package com.kely.design.pattern.iterator.bus;

/**
 * @Description: 领导
 * @Author yangqh
 * @Date 17:04 2019/1/15
 **/
public class Leader extends DoWorker {

    public Leader(String name) {
        super(name);
    }

    @Override
    protected void doWork(String name) {
        System.out.println(name + "喝茶");
    }
}
