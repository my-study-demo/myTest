package com.kely.design.pattern.iterator.bus;

/**
 * @Description: 抽象业务:工作
 * @Author yangqh
 * @Date 17:01 2019/1/15
 **/
public abstract class DoWorker {

    protected String name;

    public DoWorker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void checkIn(String name) {
        System.out.println(name + "打上班卡");
    }

    private void checkOut(String name) {
        System.out.println(name + "打下班卡");
    }

    protected abstract void doWork(String name);

    public void execute(String name) {
        checkIn(name);
        doWork(name);
        checkOut(name);
    }
}
