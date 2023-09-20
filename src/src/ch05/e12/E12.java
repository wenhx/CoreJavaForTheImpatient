package ch05.e12;

import java.util.Arrays;

public class E12 {
    public static void run() {
        int[] ints = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(min(ints));
    }

    public static int min(int[] values) {
        int minValue = Integer.MAX_VALUE;
        for (int value : values) {
            if (value < minValue) {
                minValue = value;
            }
        }

        final int result = minValue;
        assert Arrays.stream(values).allMatch(i -> result <= i);
        return minValue;
    }
}
