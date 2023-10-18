package ch07.e04;

import java.util.HashMap;
import java.util.Map;

public class E04 {
    public static void run() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");
        map.put(5, "E");

        try {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                if (entry.getKey() % 2 == 0) {
                    map.remove(entry.getKey());
                }
            }
        } catch (java.util.ConcurrentModificationException ex) {
            System.out.println("java.util.ConcurrentModificationException happened.");
        }

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.printf("%d, %s%n", entry.getKey(), entry.getValue());
        }
    }
}
