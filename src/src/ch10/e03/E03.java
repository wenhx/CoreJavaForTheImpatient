package ch10.e03;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class E03 {
    public static void run() {
        String dir = "src";
        String word = "E01";
        try {
            ExecutorService executor = Executors.newCachedThreadPool();
            List<Callable<String>> tasks = Files.walk(Path.of(dir))
                    .map(p -> searchingTask(p.toString(), word))
                    .collect(Collectors.toList());
            System.out.println("There are " + tasks.size() + " tasks.");
            ExecutorCompletionService<String> secs = new ExecutorCompletionService<>(executor);
            List<Future<String>> futures = tasks.stream().map(c -> secs.submit(c)).collect(Collectors.toList());
            String foundFile = null;
            for (int i = 0; i < tasks.size(); i++) {
                //System.out.println("Taking the " + i + " result................................................");
                Future<String> future = secs.take();
                if (future.isDone()) {
                    foundFile = future.get();
                    if (foundFile != null && foundFile != "") {
                        System.out.println("Result: " + foundFile);
                        System.out.println("--------------------------------------------------------------------------");
                        break;
                    }
                }
            }
            executor.shutdownNow();
        } catch (IOException | InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done!");
    }

    private static Callable<String> searchingTask(String fileName, String word) {
        return () -> {
            try {
                File file = new File(fileName);
                if (file.isDirectory())
                    return null;

                try (Scanner scanner = new Scanner(Path.of(fileName))) {
                    while (scanner.hasNext()) {
                        if (Thread.currentThread().isInterrupted()) {
                            System.out.println("Thread " + fileName + " quit.");
                            return null;
                        }
                        if (word.equalsIgnoreCase(scanner.next())) {
                            return fileName;
                        }
                    }
                    System.out.println("Thread " + fileName + " not found.");
                    return "";
                }
            } catch (IOException ex) {
                System.out.println("An exception has occurred in thread " + fileName);
                return null;
            }
        };
    }
}
