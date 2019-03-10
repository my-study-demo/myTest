package com.kely.design.pattern.observer;

/**
 * 观察者
 * 订阅者
 */
public class Observable implements Observer {
    private String name;
    public Observable(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}