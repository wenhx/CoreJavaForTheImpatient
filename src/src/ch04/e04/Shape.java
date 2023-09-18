package ch04.e04;

public abstract class Shape {
    protected Point point;

    public Shape(Point point) {
        this.point = point;
    }

    public void moveBy(double dx, double dy) {
        this.point.setX(this.point.getX() + dx);
        this.point.setY(this.point.getY() + dy);
    }

    public abstract Point getCenter();
}
