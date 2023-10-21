package com.assistt.training.advanced.java.multithread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CounterThread extends Thread {
    public static volatile long counter = 0;
    public static AtomicLong counter2 = new AtomicLong();
    public static ReentrantLock lock = new ReentrantLock();
    public static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private final CountDownLatch countDownLatch;

    public CounterThread(final CountDownLatch countDownLatchParam) {

        countDownLatch = countDownLatchParam;
    }

    public synchronized static void increase(){
            counter++;
    }

    public  static void increaseLock(){
        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10_000_000; i++) {
            // increase();
            counter2.incrementAndGet();
        }
        countDownLatch.countDown();
    }
}
