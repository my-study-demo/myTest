package com.kely.thread.demo;

/**
 * @Description:
 * 通过实现Runnable接口，实现run方法，接口的实现类的实例作为Thread的target作为参数传入带参的Thread构造函数，通过调用start()方法启动线程
 * @Author yangqh
 * @Date 15:29 2019/1/10
 * @Param
 * @Return
 **/
public class ThreadDemo02 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread t1 = new Thread(new MyThread());
        t1.start();
    }

    static class MyThread implements Runnable {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            System.out.println(Thread.currentThread().getName() + "-->我是通过实现接口的线程实现方式！");
        }
    }
}


