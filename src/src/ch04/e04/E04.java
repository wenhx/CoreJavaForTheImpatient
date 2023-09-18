package ch04.e04;

public class E04 {
    public static void run() {
        Shape[] shapes = new Shape[] {
                new Circle(new Point(0, 0), 10),
                new Line(new Point(0, 0), new Point(8, 8)),
                new Rectangle(new Point(20, 20), 10, 10)
        };
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}
