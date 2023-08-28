package ch02;

public class E05 {
    public static void run() {
        Point p = new Point(3, 4).translate(1, 3).scale(0.5);
        System.out.println("The result should be (2,3.5)");
        System.out.printf("p.getX() = %g%n", p.getX());
        System.out.printf("p.getY() = %g%n", p.getY());
    }
}