package com.kely.thread.examples.util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description: CyclicBarrier有2个构造函数,第二个构造函数第二个参数传递的一个Runnable,意思这个线程先执行
 * @Author yangqh
 * @Date 15:44 2019/1/13
 * @Param 
 * @Return
 * @see {https://blog.csdn.net/coderinchina/article/details/54914852}
 **/
public class CyclicBarrierExample2 {
    
    public static void main(String[] args) {
        int num = 5;
        CyclicBarrier barrier = new CyclicBarrier(num, new Leader());
        for (int i = 0; i < num; i++) {
            new Thread(new Employee(barrier)).start();
        }
    }

    static class Leader implements Runnable {
        @Override
        public void run() {
            System.out.println("吃饭前我先说几句");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Employee implements Runnable {
        private CyclicBarrier barrier;

        public Employee(final CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println("都在等领导说完话准备吃");
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("说了30分钟准备用筷子开始吃了");
        }
    }
}
