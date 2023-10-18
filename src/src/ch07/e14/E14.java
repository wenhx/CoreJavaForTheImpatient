package ch07.e14;

import java.util.*;

public class E14 {
    public static void run() {
        List<Integer> list1 = getNumbers(10);
        for (Integer i : list1) {
            System.out.print(i + ", ");
        }
        System.out.println();
        list1.add(Integer.MAX_VALUE);
    }

    static List<Integer> getNumbers(int n) {
        return new ImmutableNumberList(n);
    }
}
