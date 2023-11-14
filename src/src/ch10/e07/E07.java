package ch10.e07;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class E07 {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final Random random = new Random();

    public static void run() {
        ConcurrentHashMap<String, Long> map = BuildConcurrentHashMap();
        AtomicLong largest = new AtomicLong(Long.MIN_VALUE);
        Map.Entry<String, Long> entryHavMaxValue = map.reduceEntries(100, (maxEntry, e) -> {
            System.out.printf("Key: %s, Value: %d.%n", e.getKey(), e.getValue());
            long max = largest.updateAndGet(m -> Math.max(m, e.getValue()));
            if (max == maxEntry.getValue())
                return maxEntry;
            return e;
        });
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.printf("Key: %s, Value: %d.%n", entryHavMaxValue.getKey(), entryHavMaxValue.getValue());
    }

    private static ConcurrentHashMap<String, Long> BuildConcurrentHashMap() {
        ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            map.put(generateRandomString(10), Long.valueOf(r.nextInt(200)));
        }
        return map;
    }

    private static String generateRandomString(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException();
        }

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
