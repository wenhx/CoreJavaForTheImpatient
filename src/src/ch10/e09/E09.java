package ch10.e09;

import java.util.Random;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;
import java.util.stream.Stream;

public class E09 {
    public static void run() {
        LongBinaryOperator accumulator = (x, y) -> Math.max(x, y);
        LongAccumulator longAccumulator = new LongAccumulator(accumulator, Long.MIN_VALUE);
        Random r = new Random();
        Stream.generate(r::nextLong)
                .limit(1000000)
                .parallel()
                .forEach(longAccumulator::accumulate);
        System.out.println("The max number is: " + longAccumulator.get());
    }
}
