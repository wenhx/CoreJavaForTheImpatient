package ch06.e10;

public class E10 {
    public static void run() {
        Integer[] array1 = new Integer[] { null, 3, null, 2, 1, null, 10 };
        System.out.printf("Min: %d%n", Arrays.min(array1));
        System.out.printf("Max: %d%n", Arrays.max(array1));
    }
}
