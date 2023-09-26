package ch06.e07;

public class E07 {
    public static void run() {
        Pair<String> pair1 = new Pair<>("Item 1", "Item 2");
        System.out.printf("Item1: %s, Item2: %s%n", pair1.getItem1(), pair1.getItem2());
        Pair<Integer> pair2 = new Pair<>(1, 2);
        System.out.printf("Item1: %d, Item2: %d%n", pair2.getItem1(), pair2.getItem2());
    }
}
