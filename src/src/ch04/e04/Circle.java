package ch04.e04;

public class Circle extends Shape {
    private double radius;

    public Circle(Point center, double radius) {
        super(center);
        this.radius = radius;
    }

    @Override
    public Point getCenter() {
        return super.point;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", point=" + point +
                '}';
    }
}
