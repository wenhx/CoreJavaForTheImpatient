package ch10.e11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.*;

public class E11 {
    public static void run() {
        BlockingQueue<File> paths = new LinkedBlockingQueue<>();
        BlockingQueue<Map<String, Integer>> results = new LinkedBlockingQueue<>();
        String dir = "src";
        try {
            Files.walk(Path.of(dir))
                    .map(Path::toFile)
                    .filter(f -> f.isFile() && f.toString().endsWith(".java"))
                    .forEach(f -> {
                        try {
                            paths.put(f);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
            System.out.println("There are " + paths.size() + " files to be searched.");
            int threadCount = 10;
            ExecutorService executor = Executors.newFixedThreadPool(threadCount);
            CountDownLatch latch = new CountDownLatch(threadCount);
            for (int i = 0; i < threadCount; i++) {
                executor.execute(() -> {
                    File file;
                    while ((file = paths.poll()) != null) {
                        HashMap<String, Integer> map = new HashMap<>();
                        try (Scanner scanner = new Scanner(file)) {
                            scanner.useDelimiter("\\W+");
                            while (scanner.hasNext()) {
                                String word = scanner.next();
                                map.compute(word, (k, v) -> v == null ? 0 : v + 1);
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("File " + file + " not found.");
                        }
                        results.offer(map);
                    }
                    latch.countDown();
                });
            }
            latch.await();
            executor.shutdown();
            System.out.println("There are " + results.size() + " maps.");
            Thread mergeThread = new Thread(() -> {
                Map<String, Integer> counter = new HashMap<>();
                results.stream()
                        .forEach(map -> {
                            map.forEach((k1, v1) -> {
                                counter.compute(k1, (k2, v2) -> v2 == null ? v1 : v1 + v2);
                            });
                        });
                System.out.println("There are " + counter.size() + " different words.");
                System.out.println("------------------------------------------------------");
                System.out.println("The ten most common words:");
                counter.entrySet().stream()
                        .sorted(Comparator.comparingInt(e -> -e.getValue()))
                        .limit(10)
                        .forEach(System.out::println);
            });
            mergeThread.start();
            mergeThread.join();
            System.out.println("Done!");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
