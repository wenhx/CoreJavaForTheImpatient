package ch10.e13;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class E13 {
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
            ExecutorCompletionService<Map<String, Integer>> ecService = new ExecutorCompletionService<>(executor);
            for (Callable<Map<String, Integer>> task : tasks) {
                ecService.submit(task);
            }
            HashMap<String, Integer> counter = new HashMap<>();
            for (int i = 0; i < tasks.size(); i++) {
                Map<String, Integer> map = ecService.take().get();
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    counter.compute(entry.getKey(), (k, v) -> v == null ? entry.getValue() : v + entry.getValue());
                }
            }
            executor.shutdown();
            System.out.println("There are " + counter.size() + " different words.");
            System.out.println("------------------------------------------------------");
            System.out.println("The ten most common words:");
            counter.entrySet().stream()
                    .sorted(Comparator.comparingInt(e -> -e.getValue()))
                    .limit(10)
                    .forEach(System.out::println);
            System.out.println("Done!");
        } catch (IOException | InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
