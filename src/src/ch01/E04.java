package ch01;

public class E04 {
    public static void Run() {
        System.out.println("Chapter 1 exercise 4.");
        double result1 = Math.nextDown(Double.POSITIVE_INFINITY);
        System.out.printf("The largest positive integer value in type double is: %g", result1);
        System.out.println();
        double result2 = Math.nextUp(0);
        System.out.printf("The smallest positive integer value in type double is: %g", result2);
    }
}
