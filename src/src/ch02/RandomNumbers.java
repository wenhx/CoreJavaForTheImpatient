package ch02;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumbers {
    private static final Random generator = new Random();

    public static int nextInt(int low, int high) {
        return low + generator.nextInt(high - low + 1);
    }

    public static int randomElement(int[] array) {
        if (array == null || array.length == 0)
            return 0;

        int randomIndex = generator.nextInt(array.length);
        return  array[randomIndex];
    }

    public static int randomElement(ArrayList<Integer> list) {
        if (list == null || list.isEmpty())
            return 0;

        int randomIndex = generator.nextInt(list.size());
        return list.get(randomIndex);
    }
}
