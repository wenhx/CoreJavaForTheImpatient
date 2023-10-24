package ch08.e04;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class E04 {
    public static void run() {
        generate(0, 25214903917l, 11, (long) Math.pow(2, 48), 10000).limit(100).forEach(System.out::println);
    }

    public static Stream<Long> generate(long seed, long a, long c, long m, long max) {
        AtomicLong last = new AtomicLong(seed);
        return Stream.generate(() -> {
            last.set((((a * last.get()) + c) % m) % max);
            return last.get();
        });
    }
}
