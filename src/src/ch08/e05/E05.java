package ch08.e05;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class E05 {
    public static void run() {
        letters("IntStream").forEach(System.out::println);
    }

    public static Stream<String> letters(String str) {
        return IntStream.range(0, str.length()).mapToObj(i -> str.substring(i, i + 1));
    }
}
