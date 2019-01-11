package com.kely.thread.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Description:
 * 线程实现方式3：通过Callable和FutureTask创建线程
 * a:创建Callable接口的实现类 ，并实现Call方法
 * b:创建Callable实现类的实现，使用FutureTask类包装Callable对象，该FutureTask对象封装了Callable对象的Call方法的返回值
 * c:使用FutureTask对象作为Thread对象的target创建并启动线程
 * d:调用FutureTask对象的get()来获取子线程执行结束的返回值
 * @Author yangqh
 * @Date 15:28 2019/1/10
 * @Param
 * @Return
 **/
public class ThreadDemo03 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Callable<Object> oneCallable = new Tickets<Object>();
        FutureTask<Object> oneTask = new FutureTask<Object>(oneCallable);
        Thread t = new Thread(oneTask);
        System.out.println(Thread.currentThread().getName());
        t.start();
    }

    static class Tickets<Object> implements Callable<Object> { //重写call方法
        @Override
        public Object call() throws Exception {
            // TODO Auto-generated method stub
            System.out.println(Thread.currentThread().getName() + "-->我是通过实现Callable接口通过FutureTask包装器来实现的线程");
            return null;
        }
    }
}