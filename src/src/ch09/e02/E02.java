package ch09.e02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class E02 {
    public static void run() {
        String file = "src\\ch09\\e02\\chapter9.txt";
        try (Scanner scanner = new Scanner(Path.of(file))) {
            scanner.useDelimiter("\\PL+");
            AtomicInteger lineNumber = new AtomicInteger(1);
            Stream<CharSequence> stream = Stream.iterate("", str -> scanner.hasNext(), str -> scanner.next())
                    .skip(1)
                    .distinct()
                    .sorted()
                    .<CharSequence>map(str -> lineNumber.getAndIncrement() + ": " + str);
            String newFile = file.replace(".txt", ".toc");
            Files.write(Path.of(newFile), stream::iterator, StandardOpenOption.CREATE_NEW);
            System.out.println("Done!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
