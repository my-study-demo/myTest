package com;

interface Cat {

    void play(); //抽象方法 ​

    //静态方法 ​
    static void eat() {
        System.out.println("猫吃鱼");
    }

    //默认方法
    default void run() {
        System.out.println("猫跑");
    }

    //默认方法
    default void climb() {
        System.out.println("猫爬树");
    }
}
