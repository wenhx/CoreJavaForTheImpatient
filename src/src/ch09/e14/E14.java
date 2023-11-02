package ch09.e14;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;

public class E14 {
    public static void run() {
        Point_v1[] points = { new Point_v1(1, 1), new Point_v1(2, 2), new Point_v1(3, 3) };
        String fileName = "src\\ch09\\e14\\Points.data";
        try {
            writePointArray(points, fileName);
            Point_v1[] points1 = readPointArray(fileName);
            Arrays.stream(points1).forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writePointArray(Point_v1[] points, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Path.of(fileName)))) {
            oos.writeInt(points.length);
            for (Point_v1 point : points) {
                oos.writeObject(point);
            }
        }
    }

    public static Point_v1[] readPointArray(String fileName) throws IOException, ClassNotFoundException {
        ArrayList<Point_v1> points = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Path.of(fileName), StandardOpenOption.READ))) {
            int arrayLength = ois.readInt();
            for (int i = 0; i < arrayLength; i++) {
                Point_v1 o = (Point_v1) ois.readObject();
                points.add(o);
            }
            return points.toArray(new Point_v1[0]);
        }
    }
}
