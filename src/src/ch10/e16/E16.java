package ch10.e16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E16 {
    public static long count = 0;

    public static void run() {
        String dir = "src";
        try {
            List<Thread> tasks = Files.walk(Path.of(dir))
                    .filter(p -> p.toString().endsWith(".java"))
                    .map(p -> {
                        Thread thread = new Thread(() -> {
                            try (Scanner scanner = new Scanner(p)) {
                                while (scanner.hasNext()) {
                                    scanner.next();
                                    count++;
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                        thread.start();
                        return thread;
                    }).collect(Collectors.toList());
            for (Thread task : tasks) {
                task.join();
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("There " + count + " words.");
        System.out.println("Done!");
    }
}
