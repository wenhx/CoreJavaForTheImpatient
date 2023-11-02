package ch09.e05;

import java.nio.charset.Charset;
import java.util.Map;

public class E05 {
    public static void run() {
        for (Map.Entry<String, Charset> entry : Charset.availableCharsets().entrySet()) {
            try {
                String replacement = new String(entry.getValue().newEncoder().replacement());
                System.out.printf("Charset: %s, replacement: %s%n", entry.getKey(), replacement);
            } catch (RuntimeException ex) {
                System.out.printf("Charset: %s doesn't have a replacement.%n", entry.getKey());
            }
        }
    }
}
