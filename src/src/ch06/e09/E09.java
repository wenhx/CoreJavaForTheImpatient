package ch06.e09;

import ch06.e07.Pair;

import java.util.ArrayList;

public class E09 {
    public static void run() {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            integers.add(i);
        }
        Pair<Integer> pair = Arrays.firstLast(integers);
        System.out.printf("First: %d, Last: %d", pair.getItem1(), pair.getItem2());
    }
}
