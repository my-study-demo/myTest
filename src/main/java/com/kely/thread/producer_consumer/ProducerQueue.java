package com.kely.thread.producer_consumer;

import java.util.concurrent.BlockingQueue;

public class ProducerQueue implements Runnable {

    private final BlockingQueue proQueue;

    public ProducerQueue(BlockingQueue proQueue) {
        this.proQueue = proQueue;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("生产者生产的苹果编号为 : " + i);  //放入十个苹果编号 为1到10
                proQueue.put(i);
                            /*Thread.sleep(3000);*/
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }

        }

    }


}