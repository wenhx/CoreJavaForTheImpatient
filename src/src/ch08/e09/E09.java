package ch08.e09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.Stream;

public class E09 {
    public static void run() {
        String filePath = "src\\ch08\\e07\\chapter9.txt";
        File file = new File(filePath);
        try {
            Scanner scanner = new Scanner(file);
            Stream<String> stream = Stream.iterate("", str -> scanner.hasNext(), str -> scanner.next());
            OptionalDouble result = stream.mapToInt(String::length).average();
            System.out.printf("The average length of all words is %g.%n", result.getAsDouble());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
