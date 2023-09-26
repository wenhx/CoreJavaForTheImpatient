package ch06.e20;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class E20 {
    public static void run() {
        String[] repeatedStrings = repeat(3, "Hello", "World", "!"); // 0,1,2 | 3,4,5 | 6,7,8
        System.out.println(Arrays.toString(repeatedStrings));
    }
    @SafeVarargs
    public static final <T> T[] repeat(int n, T... objs) {
        if (n < 0)
            throw new IllegalArgumentException("Number of copies (n) must be non-negative.");
        Objects.requireNonNull(objs);
        if (objs.length == 0)
            throw new IllegalArgumentException("objs must contain at least one element.");

        T[] newArray = (T[]) Array.newInstance(objs.getClass().getComponentType(), objs.length * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < objs.length; j++) {
                newArray[(i * objs.length) + j] = objs[j];
            }
        }
        return newArray;
    }
}