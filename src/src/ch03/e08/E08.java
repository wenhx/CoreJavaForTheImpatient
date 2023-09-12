package ch03.e08;

public class E08 {
    public static void run() throws InterruptedException {
        Runnable run1 = new Greeter(100, "Runnable 1");
        Runnable run2 = new Greeter(100, "Runnable 2");
        Thread thread1 = new Thread(run1);
        Thread thread2 = new Thread(run2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
