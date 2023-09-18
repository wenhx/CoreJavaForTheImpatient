package ch04.e04;

public class Line extends Shape {
    private Point to;

    public Line(Point point, Point to) {
        super(point);
        this.to = to;
    }

    @Override
    public Point getCenter() {
        return new Point((point.getX() + to.getX()) / 2, (point.getY()) + to.getY() / 2);
    }

    @Override
    public String toString() {
        return "Line{" +
                "to=" + to +
                ", point=" + point +
                '}';
    }
}
