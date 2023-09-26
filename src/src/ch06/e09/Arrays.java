package ch06.e09;

import ch06.e07.Pair;

import java.util.ArrayList;
import java.util.Objects;

public class Arrays {
    public static <E> Pair<E> firstLast(ArrayList<E> a) {
        Objects.requireNonNull(a);
        if (a.size() < 2)
            throw new IllegalArgumentException("a must conains aleast two elements.");

        Pair<E> result = new Pair<>(a.get(0), a.get(a.size() - 1));
        return result;
    }
}
