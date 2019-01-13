package com.kely.thread.examples.util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description: CyclicBarrier和CountDownLatch的区别:
 * CountDownLatch的计数器只能使用一次,而CyclicBarrier的计数器可以使用reset()方法重置,所以CyclicBarrier能处理的业务场景相对CountDownLatch更多
 * @Author yangqh
 * @Date 15:44 2019/1/13
 * @Param
 * @Return
 * @see {https://blog.csdn.net/coderinchina/article/details/54914852}
 **/
public class CyclicBarrierExample {

    static class Employee implements Runnable {
        private String name;
        private CyclicBarrier barrier;

        public Employee(String name, final CyclicBarrier barrier) {
            this.name = name;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + "已经到达万达商场等待");
                barrier.await(); //等待最后一个线程到达（底层会去判断）
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(name + "上车");
        }
    }

    public static void main(String[] args) {
        int num = 3;
        String[] strs = {"主管", "小明", "小王"};
        CyclicBarrier barrier = new CyclicBarrier(num);
        for (int i = 0; i < num; i++) {
            new Thread(new Employee(strs[i], barrier)).start();
        }
    }
}