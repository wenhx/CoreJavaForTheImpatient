package ch10.e14;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class E14 {
    public static void run() {
        ConcurrentHashMap<String, Integer> counter = new ConcurrentHashMap<>();
        String dir = "src";
        try {
            List<Callable<Void>> tasks = Files.walk(Path.of(dir))
                    .map(Path::toFile)
                    .filter(f -> f.isFile() && f.toString().endsWith(".java"))
                    .map(f -> {
                        Callable<Void> task = () -> {
                            try (Scanner scanner = new Scanner(f)) {
                                scanner.useDelimiter("\\W+");
                                while (scanner.hasNext()) {
                                    String word = scanner.next();
                                    counter.compute(word, (k, v) -> v == null ? 0 : v + 1);
                                }
                            } catch (FileNotFoundException e) {
                                System.out.println("File " + f + " not found.");
                            }
                            return null;
                        };
                        return task;
                    })
                    .collect(Collectors.toList());
            System.out.println("There are " + tasks.size() + " files to be searched.");
            int threadCount = 10;
            ExecutorService executor = Executors.newFixedThreadPool(threadCount);
            executor.invokeAll(tasks);
            executor.shutdown();
            System.out.println("There are " + counter.size() + " different words.");
            System.out.println("------------------------------------------------------");
            System.out.println("The ten most common words:");
            counter.entrySet().stream()
                    .sorted(Comparator.comparingInt(e -> -e.getValue()))
                    .limit(10)
                    .forEach(System.out::println);
            System.out.println("Done!");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
