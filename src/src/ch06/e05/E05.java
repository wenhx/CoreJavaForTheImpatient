package ch06.e05;

public class E05 {
    public static void run() {
        Double[] swapped1 = E05.<Double>swap(0, 1, 1.5, 2.0, 3.0);
        Number[] swapped2 = swap(0, 1, 1.5, 2, 3);
    }

    public static <T> T[] swap(int i, int j, T... values) {
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        return values;
    }
}
