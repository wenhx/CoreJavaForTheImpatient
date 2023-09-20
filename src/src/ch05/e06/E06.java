package ch05.e06;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class E06 {
    public static void a(Path path) {
        BufferedReader in = null;

        try {
            in = Files.newBufferedReader(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Caught IOException:" + e.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.err.println("Caught IOException:" + e.getMessage());
                }
            }
        }
    }

    public static void b(Path path) {
        BufferedReader in = null;

        try {
            try {
                in = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            } finally {
                if (in != null) {
                    in.close();
                }
            }
        } catch (IOException e) {
            System.err.println("Caught IOException:" + e.getMessage());
        }
    }

    public static void c(Path path) {
        try (BufferedReader in = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
        } catch (IOException e) {
            System.err.println("Caught IOException:" + e.getMessage());
        }
    }
}
