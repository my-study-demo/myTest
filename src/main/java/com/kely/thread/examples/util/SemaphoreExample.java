package com.kely.thread.examples.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Description: semaphore(信号量)是用来控制同时访问特定资源的线程数量,它通过协调各个线程,以保证合理的使用公共资源.这个跟队列有点像,画图理解更直观,
 * @Author yangqh
 * @Date 15:11 2019/1/13
 * @Param 
 * @Return
 * @see {https://blog.csdn.net/coderinchina/article/details/54914852}
 **/
public class SemaphoreExample {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(2);
        final int count = 5;
        for (int i = 0; i < count; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("线程:" + Thread.currentThread().getName() + "开始下载");
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("线程:" + Thread.currentThread().getName() + "下载完毕");
                        semaphore.release();
                    }
                }
            };
            //放在线程池中去维护
            service.execute(runnable);
        }
        service.shutdown();
    }
}