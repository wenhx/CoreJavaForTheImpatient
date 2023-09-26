package ch06.e08;

import java.util.Objects;

public class Pair<E extends Comparable<E>> {
    private E item1;
    private E item2;

    public Pair(E item1, E item2) {
        Objects.requireNonNull(item1);
        Objects.requireNonNull(item2);
        this.item1 = item1;
        this.item2 = item2;
    }

    public E getItem1() {
        return item1;
    }

    public E getItem2() {
        return item2;
    }

    public E max() {
        int comparedResult = item1.compareTo(item2);
        if (comparedResult > 0)
            return item1;
        if (comparedResult < 0)
            return item2;
        return null;
    }

    public E min() {
        int comparedResult = item1.compareTo(item2);
        if (comparedResult < 0)
            return item1;
        if (comparedResult > 0)
            return item2;
        return null;
    }
}