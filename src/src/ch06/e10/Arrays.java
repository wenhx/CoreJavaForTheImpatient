package ch06.e10;

import java.util.Objects;
import java.util.function.BiPredicate;

public class Arrays {
    public static <T extends Comparable<T>> T min(T[] array) {
        Objects.requireNonNull(array);
        return compareCore(array, (r, e) -> r.compareTo(e) > 0);
    }

    public static <T extends Comparable<T>> T max(T[] array) {
        Objects.requireNonNull(array);
        return compareCore(array, (r, e) -> r.compareTo(e) < 0);
    }

    public static <T extends Comparable<T>> T compareCore(T[] array, BiPredicate<T, T> comparer) {
        if (array.length == 0)
            return null;
        if (array.length == 1)
            return array[0];

        T result = null;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null)
                continue;
            if (result == null) {
                result = array[i];
            } else if (comparer.test(result, array[i])) {
                result = array[i];
            }
        }
        return result;
    }
}
