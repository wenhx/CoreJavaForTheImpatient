package ch09.e14;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Point implements Serializable {
    private static final long serialVersionUID = -3209867812082671334L;
    private double[] coordinates = new double[] { 0, 0 };

    public Point(double x, double y) {
        coordinates[0] = x;
        coordinates[1] = y;
    }

    public double getX() {
        return coordinates[0];
    }

    public double getY() {
        return coordinates[1];
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + coordinates[0] +
                ", y=" + coordinates[1] +
                '}';
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField getField = in.readFields();
        this.coordinates = (double[]) getField.get("coordinates", null);
        if (this.coordinates != null)
            return;

        double x = getField.get("x", 0.0);
        double y = getField.get("y", 0.0);
        this.coordinates = new double[2];
        this.coordinates[0] = x;
        this.coordinates[1] = y;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }
}
