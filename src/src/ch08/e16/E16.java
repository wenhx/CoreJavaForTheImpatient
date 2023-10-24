package ch08.e16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class E16 {
    public static void run() {
        String filePath = "src\\ch08\\e16\\book-war-and-peace.txt";
        File file = new File(filePath);
        runCore(file, UnaryOperator.identity(), "Serial: ");
        runCore(file, s -> s.parallel(), "Parallel: ");
    }

    private static void runCore(File file, UnaryOperator<Stream<String>> operator, String label) {
        long start = System.currentTimeMillis();
        printTheLongestStrings(file, operator);
        long end = System.currentTimeMillis();
        long executionTime = end - start;
        System.out.println(label + "Execution time: " + executionTime);
        System.out.println("-------------------------------------------------------------");
    }

    private static void printTheLongestStrings(File file, UnaryOperator<Stream<String>> operator) {
        try {
            Scanner scanner = new Scanner(file);
            Stream<String> stream = operator.apply(Stream.iterate("", str -> scanner.hasNext(), str -> scanner.next()));
            Stream<String> fiveHundredLogestStrings = stream
                    .sorted(Comparator.comparingInt(String::length))
                    .limit(500);
            System.out.println(fiveHundredLogestStrings.count());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
