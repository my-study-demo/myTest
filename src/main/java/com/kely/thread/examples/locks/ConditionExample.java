package com.kely.thread.examples.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @Description: condition测试
 * @Author yangqh
 * @Date 14:36 2019/1/14
 * @Param
 * @Return
 **/
public class ConditionExample {

    public static void main(String[] args) {

        // 创建并发访问的账户
        MyCount myCount = new MyCount("95599200901215522", 10000);
        // 创建一个线程池,// #假设改成2会怎么样??
        ExecutorService pool = newFixedThreadPool(3);
        Thread t1 = new SaveThread("张三", myCount, 1000);
        Thread t2 = new SaveThread("李四", myCount, 1000);
        Thread t3 = new DrawThread("王五", myCount, 12600);
        Thread t4 = new SaveThread("老张", myCount, 600);
        Thread t5 = new DrawThread("老牛", myCount, 1300);
        Thread t6 = new DrawThread("胖子", myCount, 800);
        Thread t7 = new SaveThread("测试", myCount, 2100);
        // 执行各个线程
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);
        pool.execute(t7);
        // 关闭线程池
        pool.shutdown();
    }

    /**
     * 存款线程类
     */
    static class SaveThread extends Thread {
        private String name;
        private MyCount myCount;
        private int x;

        SaveThread(String name, MyCount myCount, int x) {
            this.name = name;
            this.myCount = myCount;
            this.x = x;
        }

        @Override
        public void run() {
            myCount.saving(x, name);
        }
    }

    /**
     * 取款线程类
     */
    static class DrawThread extends Thread {
        private String name;
        private MyCount myCount;
        private int x;

        DrawThread(String name, MyCount myCount, int x) {
            this.name = name;
            this.myCount = myCount;
            this.x = x;
        }

        @Override
        public void run() {
            myCount.drawing(x, name);
        }
    }

    /**
     * 普通银行账户，不可透支
     */
    static class MyCount {
        private String oid;
        private int cash;
        private Lock lock = new ReentrantLock();
        private Condition _save = lock.newCondition();
        private Condition _draw = lock.newCondition();

        MyCount(String oid, int cash) {
            this.oid = oid;
            this.cash = cash;
        }

        /**
         * 存款
         *
         * @param x    操作金额
         * @param name 操作人
         */
        public void saving(int x, String name) {
            // 获取锁
            lock.lock();
            if (x > 0) {
                // 存款
                cash += x;
                System.out.println(name + "存款" + x + "，当前余额为" + cash);
            }
            // 唤醒所有等待线程。
            _draw.signalAll();
            // 释放锁
            lock.unlock();
        }

        /**
         * 取款
         *
         * @param x    操作金额
         * @param name 操作人
         */
        public void drawing(int x, String name) {
            lock.lock();
            try {
                while (cash - x < 0) {
                    // 阻塞取款操作, await之后就隐示自动释放了lock，直到被唤醒自动获取
                    _draw.await();

                    System.out.println(name + "阻塞中");
                }
                {
                    // 取款
                    cash -= x;
                    System.out.println(name + "取款" + x + "，当前余额为" + cash);
                }
                // 唤醒所有存款操作
                _save.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 释放锁
                lock.unlock();
            }
        }
    }
}