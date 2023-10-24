package ch08.e03;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class E03 {
    public static void run() {
        int[] values = { 1, 4, 9, 16 };
        Stream<int[]> stream1 = Stream.of(values);
        IntStream stream2 = IntStream.of(values);
        System.out.println(stream1.getClass());
        System.out.println(stream2.getClass());
    }
}
