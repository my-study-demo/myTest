package com.kely.design.pattern.iterator.bus;

/**
 * @Description: 美工
 * @Author yangqh
 * @Date 17:04 2019/1/15
 **/
public class ArtDesigner extends DoWorker {

    public ArtDesigner(String name) {
        super(name);
    }

    @Override
    protected void doWork(String name) {
        System.out.println(name + "画图");
    }
}
