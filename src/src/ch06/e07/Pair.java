package ch06.e07;

public class Pair<E> {
    private E item1;
    private E item2;

    public Pair(E item1, E item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public E getItem1() {
        return item1;
    }

    public E getItem2() {
        return item2;
    }

    @Override
    public String toString() {
        return "Pair { " +
                "item1=" + item1 +
                ", item2=" + item2 +
                " }";
    }
}
