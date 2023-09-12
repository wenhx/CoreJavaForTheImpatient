package ch03.e13;

import java.util.Objects;

public class E13 {
    public static void run() {
        join(() -> System.out.println("Run 1"),
                () -> System.out.println("Run 2"),
                () -> System.out.println("Run 3"),
                () -> System.out.println("Run 4"),
                () -> System.out.println("Run 5")).run();
    }

    public static Runnable join(Runnable... runs) {
        Objects.requireNonNull(runs);
        return () -> {
            for (Runnable run : runs) {
                run.run();
            }
        };
    }
}
