package ch10.e08;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class E08 {
    public static void run() {
        AtomicLong counter1 = new AtomicLong();
        Runnable incrementTask1 = () -> counter1.getAndIncrement();
        LongAdder counter2 = new LongAdder();
        Runnable incrementTask2 = () -> counter2.increment();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("AtomicLong");
                runCore(incrementTask1);
                System.out.println("LongAdder");
                runCore(incrementTask2);
                System.out.println("---------------------------------------------------------------------------------");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void runCore(Runnable incrementTask) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[1000];
        for (int i = 0; i < threads.length; i++) {
            Runnable task = () -> {
                for (int j = 0; j < 100000; j++) {
                    incrementTask.run();
                }
            };
            Thread thread = new Thread(task);
            thread.start();
            threads[i] = thread;
        }
        for (Thread thread : threads) {
            thread.join();
        }
        long end = System.currentTimeMillis();
        long invokedTime = end - start;
        System.out.println("The execution time is " +  invokedTime + " milliseconds.");
    }
}
