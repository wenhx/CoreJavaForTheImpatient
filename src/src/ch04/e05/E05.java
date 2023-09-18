package ch04.e05;

import ch04.e04.Point;

import java.util.Objects;

public class E05 {
    public static void run() {
        Point p1 = new Point(100, 200);
        System.out.println(p1);
        Point p2 = null;
        try {
            p2 = (Point)p1.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        System.out.println(p2);
        System.out.println(Objects.equals(p1, p2));
    }
}