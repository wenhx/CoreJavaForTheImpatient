package ch02;

/**
 * A <code>Point</code> representing a location in (x,y) coordinate space.
 * @author wenhx
 * @version 1.0
 */
public class MutatorPoint {
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    private double x = 0;
    private double y = 0;

    public MutatorPoint() {

    }

    public MutatorPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public MutatorPoint translate(double x, double y) {
        this.x += x;
        this.y += y;
        return this;
    }

    public MutatorPoint scale(double factor) {
        this.x *= factor;
        this.y *= factor;
        return this;
    }
}
