package ch06.e08;

public class E08 {
    public static void run() {
        Pair<Integer> pare1 = new Pair<>(1, 2);
        System.out.printf("Max: %d, Min: %d%n", pare1.min(), pare1.max());
        Pair<Integer> pare2 = new Pair<>(2, 1);
        System.out.printf("Max: %d, Min: %d%n", pare2.min(), pare2.max());
        Pair<Integer> pare3 = new Pair<>(5, 5);
        System.out.printf("Max: %d, Min: %d%n", pare3.min(), pare3.max());
    }
}
