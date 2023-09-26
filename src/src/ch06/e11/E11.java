package ch06.e11;

import ch06.e07.Pair;
import ch06.e10.Arrays;

import java.util.Objects;

public class E11 {
    public static void run() {
        Integer[] array1 = new Integer[] { null, 3, null, 2, 1, null, 10 };
        System.out.println(minMax(array1));
    }
    public static <T extends Comparable<T>> Pair<T> minMax(T[] array) {
        Objects.requireNonNull(array);
        return new Pair<>(Arrays.min(array), Arrays.max(array));
    }
}
