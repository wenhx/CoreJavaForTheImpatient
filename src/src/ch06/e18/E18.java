package ch06.e18;

import java.util.function.IntFunction;

public class E18 {
    public static void run() {
        //'repeat(int, T, java.util.function.IntFunction<T[]>)' in 'ch06.e18.E18' cannot be applied to '(int, int, <method reference>)'
        //int[] intArray = E18.repeat(10, 42, int[]::new);
        Integer[] intArray = E18.repeat(10, 42, Integer[]::new);
    }
    public static <T> T[] repeat(int n, T obj, IntFunction<T[]> constr) {
        T[] result = constr.apply(n);
        for (int i = 0; i < n; i++) {
            result[i] = obj;
        }
        return result;
    }
}
