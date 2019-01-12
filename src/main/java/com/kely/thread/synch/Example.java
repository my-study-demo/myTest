package com.kely.thread.synch;

/**
 * @Description:
 * Java同步关键字（synchronzied）
 *      实例方法同步
 *      静态方法同步
 *      实例方法中同步块
 *      静态方法中同步块
 *
 * @Author yangqh
 * @Date 15:25 2019/1/12
 * @Param
 * @Return
 * @see {http://ifeve.com/synchronized-blocks/}
 **/
public class Example {

    public static void main(String[] args) throws InterruptedException {
        /**
         * 他们的构造器引用同一个Counter实例。Counter.add方法是同步在实例上，是因为add方法是实例方法并且被标记上synchronized关键字。
         * 因此每次只允许一个线程调用该方法。另外一个线程必须要等到第一个线程退出add()方法时，才能继续执行方法。
         **/
        Counter counter = new Counter();
        Thread threadA = new CounterThread(counter);
        Thread threadB = new CounterThread(counter);

        threadA.start();
        threadB.start();
        Thread.sleep(2000);
        System.out.println(counter.count);
    }
}