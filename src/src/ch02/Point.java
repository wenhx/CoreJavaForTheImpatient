package ch02;

/**
 * A <code>Point</code> representing a location in (x,y) coordinate space.
 * @author wenhx
 * @version 1.0
 */
public class Point {
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    private double x = 0;
    private double y = 0;

    public Point() {

    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point translate(double x, double y) {
        return new Point(this.x + x, this.y + y);
    }

    public Point scale(double factor) {
        return  new Point(this.x * factor, this.y * factor);
    }
}
