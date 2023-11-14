package ch10.e10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class E10 {
    public static void run() {
        BlockingQueue<File> paths = new LinkedBlockingQueue<>();
        String dir = "src";
        String keyword = "interface";
        AtomicBoolean serachCompleted = new AtomicBoolean();
        Thread searchThread = new Thread(() -> {
            try {
                Files.walk(Path.of(dir))
                        .map(Path::toFile)
                        .filter(f -> f.isFile() && f.toString().endsWith(".java"))
                        .forEach(f -> {
                            paths.offer(f);
                        });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            paths.offer(new File(""));
            System.out.println("There are " + paths.size() + " files to be searched.");
            serachCompleted.set(true);
        });
        searchThread.start();

        Thread[] tasks = new Thread[10];
        for (int i = 0; i < tasks.length; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    File file = paths.poll();
                    if (file == null) {
                        if (serachCompleted.get())
                            return;
                        continue;
                    }
                    //System.out.println("Running " + file);
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNext()) {
                            String word = scanner.next();
                            if (keyword.equalsIgnoreCase(word)) {
                                System.out.println("Keyword found in file: " + file);
                                break;
                            }
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File " + file + " not found.");
                    }
                }
            });
            thread.start();
            tasks[i] = thread;
        }
        for (Thread task : tasks) {
            try {
                task.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Done!");
    }
}
