package ch06.e19;

import java.util.ArrayList;

public class E19 {
    public static void run() {
        for (Integer i : repeat(10, 8)) {
            System.out.println(i);
        }
    }

    public static <T> T[] repeat(int n, T obj) {
        ArrayList<T> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(obj);
        }
        return (T[])list.toArray(); // This will throw a ClassCastException at runtime.
    }
}
