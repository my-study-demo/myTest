package com;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @description:
 * @author: kely [email:yangqinghua39@163.com]
 * @date: 2018/8/27 9:39
 */
public class TestA {


    static class MyTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("到点");
        }
    }

    public static void main(String[] args) {
        //创建定时器对象
        Timer t = new Timer();
        //在3秒后执行MyTask类中的run方法
        t.schedule(new MyTask(), 3000);
        System.out.println("");
    }
}
