package ch01;

public class E16 {
    public static void Run() {
        System.out.println(average(1, 2, 3, 4, 5, 6));
    }

    public static double average(double number, double... values) {
        double sum = number;
        for (double v : values) sum += v;
        return values.length == 0 ? number : sum / (values.length + 1);
    }
}
