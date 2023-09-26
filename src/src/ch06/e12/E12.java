package ch06.e12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class E12 {
    public static void run() {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(10);
        ArrayList<Number> numbers = new ArrayList<>();
        minmax((integers), Integer::compare, numbers);
        for (Number number : numbers) {
            System.out.println(number);
        }
    }

    public static <T> void minmax(List<T> elements, Comparator<? super T> comp, List<? super T> result) {
        Objects.requireNonNull(elements);
        Objects.requireNonNull(result);
        if (elements.size() < 2)
            throw new RuntimeException("The parameter elements must conains aleast two elements.");

        T minValue = elements.get(0);
        T maxValue = elements.get(0);
        for (int i = 1; i < elements.size(); i++) {
            if (comp.compare(minValue, elements.get(i)) > 0) {
                minValue = elements.get(i);
            }
            if (comp.compare(maxValue, elements.get(i)) < 0) {
                maxValue = elements.get(i);
            }
        }
        result.clear();
        result.add(minValue);
        result.add(maxValue);
    }
}
