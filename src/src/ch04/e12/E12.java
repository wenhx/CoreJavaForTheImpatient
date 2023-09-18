package ch04.e12;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class E12 {
    final static int invokeTimes = 100000;
    final static String helloWorld = "Hello World!";

    public static void run() {
        long time1 = runTest(() -> {
            try {
                Class<?> c1 = Class.forName("java.lang.System");
                Field outField = c1.getField("out");
                Object out = outField.get(null);
                Class<?> c2 = Class.forName("java.io.PrintStream");
                Method printlnMethod = c2.getMethod("println", String.class);
                printlnMethod.invoke(out, helloWorld);
            } catch (Exception e) {
                System.out.println(e);
            }
        });
        long time2 = runTest(() -> {
            System.out.println(helloWorld);
        });
        PrintElapsedTime(time1);
        PrintElapsedTime(time2);
    }

    private static void PrintElapsedTime(long elapsedTime) {
        System.out.println("Average invoked nano seconds: " + elapsedTime / (invokeTimes * 1.0));
    }

    public static long runTest(Runnable runnable) {
        long startTime = System.nanoTime();
        for (int i = 0; i < invokeTimes; i++) {
            runnable.run();
        }
        return System.nanoTime() - startTime;
    }
}
