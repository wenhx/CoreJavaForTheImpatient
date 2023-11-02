package ch09.e04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class E04 {
    public static void run() {
        String largeFilePath = "D:\\LargeTxtFile.txt";
        runWithScanner(largeFilePath);
        runWithBufferedReader(largeFilePath);
        runWithBufferedReader2(largeFilePath);
    }

    private static void runWithScanner(String file) {
        try (Scanner scanner = new Scanner(Path.of(file))) {
            long start = System.currentTimeMillis();
            int lines = 0;
            while (scanner.hasNext()) {
                scanner.nextLine();
                lines++;
            }
            long end = System.currentTimeMillis();
            System.out.printf("There are %d lines. (%dms)%n", lines, (end - start));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void runWithBufferedReader(String file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            long start = System.currentTimeMillis();
            int lines = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                lines++;
            }
            long end = System.currentTimeMillis();
            System.out.printf("There are %d lines. (%dms)%n", lines, (end - start));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void runWithBufferedReader2(String file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            long start = System.currentTimeMillis();
            long lines = reader.lines().count();
            long end = System.currentTimeMillis();
            System.out.printf("There are %d lines. (%dms)%n", lines, (end - start));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
