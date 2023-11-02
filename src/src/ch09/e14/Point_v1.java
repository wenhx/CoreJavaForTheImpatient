package ch09.e14;

import java.io.Serializable;

public class Point_v1 implements Serializable {
    private double x;
    private double y;

    public Point_v1(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
