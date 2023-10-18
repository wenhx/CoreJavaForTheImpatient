package ch07.e16;

import java.util.Queue;

public class E16 {
    public static void run() {
        CachedImmutableIntFunctionList<Double> list = new CachedImmutableIntFunctionList<Double>(n -> 1.0 / n);
        for (int i = 1; i <= 120; i++) {
            System.out.println(i + ": " + list.get(i));
        }
        System.out.println();
        Queue<Double> cache = list.getCache();
        System.out.println(cache.size());
        System.out.println(cache.peek());
    }
}
