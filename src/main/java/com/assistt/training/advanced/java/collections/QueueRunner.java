package com.assistt.training.advanced.java.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.*;

public class QueueRunner {

    public static class MyDelayed implements Delayed {

        private long creationDate = System.currentTimeMillis();

        @Override
        public long getDelay(final TimeUnit unit) {
            return unit.convert(60000 - System.currentTimeMillis() - creationDate,
                                TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(final Delayed o) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Queue<String>         stringsLoc  = new ArrayBlockingQueue<>(1_000);
        BlockingQueue<String> stringsLoc1 = new ArrayBlockingQueue<>(1_000);
        Deque<String>         stringsLoc2 = new ArrayDeque<>();
        BlockingDeque<String> stringsLoc3;

        stringsLoc1.add("1");
        stringsLoc1.add("2");
        stringsLoc1.add("3");
        stringsLoc1.add("4");
        String pollLoc = stringsLoc1.poll();
        try {
            String takeLoc = stringsLoc1.take();
            String pollLoc1 = stringsLoc1.poll(100,
                                               TimeUnit.MILLISECONDS);
        } catch (InterruptedException eParam) {
            throw new RuntimeException(eParam);
        }

        DelayQueue<MyDelayed> stringsLoc4 = new DelayQueue<>();
        stringsLoc4.add(new MyDelayed());

        PriorityQueue<String> stringsLoc5 = new PriorityQueue<>();
    }

}
