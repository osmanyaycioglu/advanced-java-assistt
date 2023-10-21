package com.assistt.training.advanced.java.multithread;

import java.util.concurrent.*;

public class CounterRunner {


    public static final int COUNT = 5;

    public static void main(String[] args) {
        Semaphore semaphoreLoc = new Semaphore(3);
        // TH1 : semaphoreLoc.acquire();
        // TH2 : semaphoreLoc.acquire();
        // TH3 : semaphoreLoc.acquire();
        // TH4 : semaphoreLoc.acquire();
        // TH5 : semaphoreLoc.acquire();
        // TH6 : semaphoreLoc.acquire();


        CountDownLatch countDownLatchLoc = new CountDownLatch(COUNT);
        for (int i = 0; i < COUNT; i++) {
            CounterThread counterThreadLoc = new CounterThread(countDownLatchLoc);
            counterThreadLoc.start();
        }
        try {
            countDownLatchLoc.await();
        } catch (InterruptedException eParam) {
        }
        System.out.println(CounterThread.counter);
        System.out.println(CounterThread.counter2.get());


        ExecutorService executorServiceLoc = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            executorServiceLoc.execute(() -> System.out.println("hello from runnable " + Thread.currentThread()
                                                                                               .getName()));
        }
        Future<String> submitLoc = executorServiceLoc.submit(() -> {
            System.out.println("Callable başladı" + Thread.currentThread()
                                                          .getName());
            try {
                Thread.sleep(4_000);
            } catch (InterruptedException eParam) {
            }
            System.out.println("Callable bitti" + Thread.currentThread()
                                                        .getName());
            return "hello from callable";
        });
        System.out.println("Callable gönderildi " + Thread.currentThread()
                                                          .getName());
        System.out.println("Deneme1" + Thread.currentThread()
                                             .getName());
        System.out.println("Deneme2" + Thread.currentThread()
                                             .getName());
        System.out.println("Deneme3" + Thread.currentThread()
                                             .getName());
        System.out.println("Deneme4" + Thread.currentThread()
                                             .getName());

        try {
            String sLoc = submitLoc.get();
            System.out.println("s : " + sLoc);
        } catch (InterruptedException eParam) {
            throw new RuntimeException(eParam);
        } catch (ExecutionException eParam) {
            throw new RuntimeException(eParam);
        }
    }
}
