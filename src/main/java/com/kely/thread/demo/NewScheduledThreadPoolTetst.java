package com.kely.thread.demo;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @Author yangqh
 * @Date 17:10 2019/1/10
 **/
public class NewScheduledThreadPoolTetst {

    public static void main(String[] args) throws Exception {

        // 指定大小为4
        ScheduledExecutorService m = Executors.newScheduledThreadPool(4);

        m.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Date now = new Date();
                System.out.println("线程" + Thread.currentThread() + "报时：" + now);
            }
            // 延迟1s秒执行，每隔1s执行一次
        }, 1, 1, TimeUnit.SECONDS);

    }
}
