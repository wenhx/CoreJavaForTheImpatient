package ch07.e09;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class E09 {
    private static String _keyA = "A";
    private static String _keyB = "B";
    private static int _defaultValue = 1;

    public static void run() {
        runMerge(E09::merge1);
        runMerge(E09::merge2);
        runMerge(E09::merge3);
        runMerge(E09::merge4);
    }

    private static void merge4(Map<String, Integer> map, String key) {
        Integer value = map.putIfAbsent(key, _defaultValue);
        if (value != null) {
            map.put(key, value + 1);
        }
    }

    private static void merge3(Map<String, Integer> map, String key) {
        Integer value = map.getOrDefault(key, 0) + 1;
        map.put(key, value);
    }

    private static void merge2(Map<String, Integer> map, String key) {
        Integer value = map.get(key);
        if (value == null) {
            map.put(key, _defaultValue);
        } else {
            map.put(key, value + 1);
        }
    }

    private static void runMerge(BiConsumer<Map<String, Integer>, String> merge) {
        Map<String, Integer> map = getMap();
        printMap(map);
        merge.accept(map, _keyA);
        merge.accept(map, _keyB);
        printMap(map);
    }

    private static void merge1(Map<String, Integer> map, String key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, _defaultValue);
        }
    }

    private static void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("[%s, %d]%n", entry.getKey(), entry.getValue());
        }
        System.out.println("-------------------------------------------------");
    }

    private static Map<String, Integer> getMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put(_keyA, 1);
        return map;
    }
}
