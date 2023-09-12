package ch03.e09;

import java.util.Objects;

public class E09 {
    public static void runTogether(Runnable... tasks) {
        Objects.requireNonNull(tasks);
        for (Runnable task : tasks) {
            Thread thread = new Thread(task);
            thread.start();
        }
    }

    public static void runInOrder(Runnable... tasks) {
        Objects.requireNonNull(tasks);
        for (Runnable task : tasks) {
            task.run();
        }
    }

    public static void run() {
        Runnable[] tasks1 = new Runnable[10];
        for (int i = 0; i < 10; i++) {
            int index = i;
            tasks1[i] = () -> System.out.printf("Tasks1.%d%n", index);
        }
        runTogether(tasks1);
        Runnable[] tasks2 = new Runnable[10];
        for (int i = 0; i < 10; i++) {
            int index = i;
            tasks2[i] = () -> System.out.printf("Tasks2.%d%n", index);
        }
        runInOrder(tasks2);
    }
}
