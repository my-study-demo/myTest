package com.kely.thread.examples.util;

import java.util.concurrent.CountDownLatch;

/**
 * @Description: CyclicBarrier和CountDownLatch的区别:
 * CountDownLatch的计数器只能使用一次,而CyclicBarrier的计数器可以使用reset()方法重置,所以CyclicBarrier能处理的业务场景相对CountDownLatch更多
 * @Author yangqh
 * @Date 15:46 2019/1/13
 * @Param
 * @Return
 **/
public class CountDownLatchExample {
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread("老二") {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + "吃完了");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread("老大") {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + "吃完了");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread("老爸") {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + "吃完了");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        System.out.println("等待三个男人吃完,女人才能上桌吃饭,等....");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("女人们可以上桌吃饭了");
    }
}