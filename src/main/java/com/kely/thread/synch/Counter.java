package com.kely.thread.synch;

public class Counter {
    long count = 0;

    public synchronized void add(long value) {
        this.count += value;
    }
}