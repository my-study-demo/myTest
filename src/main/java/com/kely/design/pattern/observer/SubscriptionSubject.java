package com.kely.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 维护一个观察者（订阅者）列表
 */
public class SubscriptionSubject implements Subject {
    private List<Observer> list = new ArrayList<Observer>();

    @Override
    public void attach(Observer observer) {
        list.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : list) {
            observer.update(message);
        }
    }
}