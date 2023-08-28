package ch02;

import java.util.ArrayList;
import java.util.Arrays;

public class E10 {
    public static void run() {
        int[] intArray = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d ", RandomNumbers.randomElement(intArray));
        }
        System.out.println();
        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d ", RandomNumbers.randomElement(intList));
        }
    }
}
