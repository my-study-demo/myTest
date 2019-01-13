package com.kely.thread.examples.util;

import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * @Description: Exchanger主要用于二个线程之间交换数据, 注意, 只能是2个线程, 如果有一个线程没执行exchange()方法, 则会一直等待, 线程就处于阻塞状态了!如果怕一直等待,可以设置时间:exchange()有一个重载的方法.
 * @Author yangqh
 * @Date 15:18 2019/1/13
 * @Param
 * @Return
 * @see {https://blog.csdn.net/coderinchina/article/details/54914852}
 **/
public class ExchangerExample {

    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();
        new Girl(exchanger).start();
        new Man(exchanger).start();
    }

    /**
     * 男人
     *
     * @author admin
     */
    static class Man extends Thread {
        Exchanger<Integer> exchanger;

        public Man(Exchanger<Integer> exchanger) {
            super();
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            int money = 0;
            for (int i = 0; i < 4; i++) {
                //年薪在10万以内
                money += 100000;
                try {
                    //存钱
                    exchanger.exchange(money);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 女人
     */
    static class Girl extends Thread {
        Exchanger<Integer> exchanger;
        int money = 0;

        public Girl(Exchanger<Integer> exchanger) {
            super();
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            for (int i = 0; i < 4; i++) {
                try {
                    money = exchanger.exchange(money);
                    System.out.println(money > 300000 ? "亲爱的" + money + "万我们可以结婚了" : money + "块这么少," + "臭屌丝活该单身,还不去赚钱娶老婆");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}