package com.kely.thread.replace.print;

import java.util.concurrent.CountDownLatch;

/**
 * 交替打印奇偶
 *
 * @author yangqh
 * @date 2019/3/20
 **/
public class ThreadPrintData {

    public static CountDownLatch latch = new CountDownLatch(2);
    private static Object lock = new Object();
    private static volatile Integer i = 0;
    private static final int TOTAL = 100;

    public static void main(String[] args) {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                while (i <= TOTAL) {
                    synchronized (lock) {
                        if (i % 2 == 1) {
                            System.out.println(Thread.currentThread().getName() + "打印：" + i++);
                        } else {
                            lock.notifyAll();
                            try {
                                if (i <= TOTAL) {
                                    lock.wait();
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };
        thread1.setName("  奇数线程");
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                while (i <= TOTAL) {
                    synchronized (lock) {
                        if (i % 2 == 0) {
                            System.out.println(Thread.currentThread().getName() + "打印：" + i++);
                        } else {
                            lock.notifyAll();
                            try {
                                if (i < TOTAL) {
                                    lock.wait();
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };
        thread2.setName("->偶数线程");
        thread1.start();
        thread2.start();
    }
}
