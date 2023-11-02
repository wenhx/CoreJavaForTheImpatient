package ch09.e15;

import ch09.e14.Point;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class E15 {
    public static void run() {
        String fileName = "src\\ch09\\e15\\PointsV1.data";
        try {
            Point[] points = readPointArray(fileName);
            for (Point point : points) {
                System.out.println(point);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Point[] readPointArray(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Path.of(fileName)))) {
            int arrayLength = ois.readInt();
            Point[] points = new Point[arrayLength];
            for (int i = 0; i < arrayLength; i++) {
                points[i] = (Point) ois.readObject();
            }
            return points;
        }
    }
}
