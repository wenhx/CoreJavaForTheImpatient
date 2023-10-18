package ch07.e13;

public class E13 {
    public static void run() {
        String key = "1";
        Cache cache = new Cache(10);
        for (int i = 0; i < 20; i++) {
            cache.put(i, i);
        }
        System.out.println(cache.size());
        for (Object o : cache.keySet()) {
            System.out.print(cache.get(o) + ", ");
        }
    }
}
