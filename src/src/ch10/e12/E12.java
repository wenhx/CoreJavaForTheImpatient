package ch10.e12;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class E12 {
    public static void run() {
        String dir = "src";
        try {
            List<Callable<Map<String, Integer>>> tasks = Files.walk(Path.of(dir))
                    .map(Path::toFile)
                    .filter(f -> f.isFile() && f.toString().endsWith(".java"))
                    .map(f -> {
                        Callable<Map<String, Integer>> task = () -> {
                            HashMap<String, Integer> map = new HashMap<>();
                            try (Scanner scanner = new Scanner(f)) {
                                scanner.useDelimiter("\\W+");
                                while (scanner.hasNext()) {
                                    String word = scanner.next();
                                    map.compute(word, (k, v) -> v == null ? 0 : v + 1);
                                }
                            } catch (FileNotFoundException e) {
                                System.out.println("File " + f + " not found.");
                            }
                            return map;
                        };
                        return task;
                    })
                    .collect(Collectors.toList());
            System.out.println("There are " + tasks.size() + " files to be searched.");
            int threadCount = 10;
            ExecutorService executor = Executors.newFixedThreadPool(threadCount);
            List<Future<Map<String, Integer>>> futures = executor.invokeAll(tasks);
            executor.shutdown();
            Map<String, Integer> counter = futures.stream().map(f -> {
                try {
                    return f.get();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }).reduce(new HashMap<String, Integer>(), (preResult, map) -> {
                HashMap<String, Integer> result = new HashMap<>(preResult);
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    result.compute(entry.getKey(), (k, v) -> v == null ? entry.getValue() : v + entry.getValue());
                }
                return result;
            });
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
