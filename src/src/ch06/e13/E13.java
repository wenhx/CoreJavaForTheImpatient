package ch06.e13;

import ch06.e12.E12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class E13 {
    public static void run() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        ArrayList<Integer> result = new ArrayList<>();
        maxmin(integers, Integer::compare, result);
        System.out.printf(Arrays.toString(result.toArray()));
    }
    public static <T> void maxmin(List<T> elements, Comparator<? super T> comp, List<? super T> result) {
        E12.minmax(elements, comp, result);
        E13.swapHelper(result, 0, 1);
    }

    public static <T> void swapHelper(List<T> elements, int i, int j) {
        T temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
}
