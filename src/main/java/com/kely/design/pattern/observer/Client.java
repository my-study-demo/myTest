package com.kely.design.pattern.observer;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject mSubscriptionSubject = new SubscriptionSubject();
        /**
         *
         */
        Observable observable1 = new Observable("xxx");
        Observable observable2 = new Observable("ooo");
        mSubscriptionSubject.attach(observable1);
        mSubscriptionSubject.attach(observable2);
        mSubscriptionSubject.notify("updated!!!");
    }
}