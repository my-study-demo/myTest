package com.kely.thread.examples.util;

/**
 * @Description: 线程变量
 * @Author yangqh
 * @Date 16:16 2019/1/12
 * @Param
 * @Return
 * @see {http://ifeve.com/java-theadlocal/}
 **/
public class ThreadLocalExample {

    public static class MyRunnable implements Runnable {

        private ThreadLocal<Integer> threadLocal =
                new ThreadLocal<Integer>();

        @Override
        public void run() {
//            synchronized (this) {
            threadLocal.set((int) (Math.random() * 100D));
//            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

            System.out.println(threadLocal.get());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        thread1.join(); //wait for thread 1 to terminate
        thread2.join(); //wait for thread 2 to terminate
    }

}
