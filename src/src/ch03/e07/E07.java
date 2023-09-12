package ch03.e07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class E07 {
    public static void run() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("D");
        strings.add("A");
        strings.add("C");
        strings.add("B");
        strings.add("Z");
        strings.add("Y");
        strings.add("F");
        strings.add("G");
        luckySort(strings, String::compareTo);
    }

    public static void luckySort(ArrayList<String> strings, Comparator<String> comparator) {
        strings.forEach(str -> System.out.printf("%s ", str));
        System.out.println();
        while (!isIncreasing(strings, comparator)) {
            Collections.shuffle(strings);
        }
        strings.forEach(str -> System.out.printf("%s ", str));
    }

    public static boolean isIncreasing(ArrayList<String> strings, Comparator<String> comparator) {
        Objects.requireNonNull(strings);
        Objects.requireNonNull(comparator);

        int count = strings.size();
        if (count <= 1)
            return true;
        String previous = strings.get(0);
        for (int i = 1; i < strings.size(); i++) {
            if (comparator.compare(previous, strings.get(i)) >= 0)
                return false;
            previous = strings.get(i);
        }
        return true;
    }
}
