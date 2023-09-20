package ch05.e08;

import java.io.PrintWriter;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

public class E08 {
    public static void run() {
        ReentrantLock lock = new ReentrantLock();
        try (AutoCloseable autoCloseable = ReentrantLockHelper(lock)) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static AutoCloseable ReentrantLockHelper (ReentrantLock lock) {
        Objects.requireNonNull(lock);
        lock.lock();
        return new AutoCloseable() {
            @Override
            public void close() throws Exception {
                try {
                    lock.unlock();
                } catch (Exception ex) {}
            }
        };
    }
}
