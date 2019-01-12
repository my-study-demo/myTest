package com.kely.thread.demo;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @Description: TODO
 * @Author yangqh
 * @Date 17:25 2019/1/10
 **/
public class ForkJoinPoolTest {


    /**
     * 定义一个可分解的的任务类，继承了RecursiveAction抽象类
     * 必须实现它的compute方法
     */
    public static class myTask extends RecursiveAction {

        private static final long serialVersionUID = 1L;

        /**
         * 定义一个分解任务的阈值——50,即一个任务最多承担50个工作量
         **/
        int THRESHOLD = 50;

        /**
         * 任务量
         **/
        int task_Num;

        CountDownLatch latch;

        myTask(int Num, CountDownLatch latch) {
            this.task_Num = Num;
            this.latch = latch;
        }

        @Override
        protected void compute() {
            if (task_Num <= THRESHOLD) {
                System.out.println(Thread.currentThread().getName() + "-->承担了" + task_Num + "份工作");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 1; i <= task_Num; i++) {
                    latch.countDown();
                }
            } else {
                //随机解成两个任务
                Random m = new Random();
                int x = m.nextInt(50);

                System.out.println(task_Num + "任务分解：" + x);

                myTask left = new myTask(x, latch);
                myTask right = new myTask(task_Num - x, latch);

                left.fork();
                right.fork();
            }
        }
    }

    public static void main(String[] args) throws Exception {

        int threadCount = 178;
        final CountDownLatch latch = new CountDownLatch(threadCount);

        //创建一个支持分解任务的线程池ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();
        myTask task = new myTask(threadCount, latch);

        pool.submit(task);
        //等待20s，观察结果
        //1
//      pool.awaitTermination(20, TimeUnit.SECONDS);
//      pool.shutdown();

        //2
//        while (latch.getCount() > 0){}
//        pool.shutdown();
//        System.out.println("下班！");

        //3
        //线程可以阻塞等待这一数量到达零。
        latch.await();
        System.out.println("下班！");
    }
}
