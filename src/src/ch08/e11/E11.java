package ch08.e11;

import java.util.Random;
import java.util.stream.Stream;

public class E11 {
    public static void run() {
        Random random = new Random();
        System.out.println(isFinite(Stream.generate(random::nextInt)));
        System.out.println(isFinite2(Stream.generate(random::nextInt)));
    }

    public static <T> boolean isFinite(Stream<T> stream) {
        //by GPT
        try {
            stream.spliterator().estimateSize();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static <T> boolean isFinite2(Stream<T> stream) {
        // by me.
        try {
            stream.count();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
