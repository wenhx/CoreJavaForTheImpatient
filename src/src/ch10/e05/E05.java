package ch10.e05;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

public class E05 {
    public static void run() {
        runCore((map, path) -> {
            File file = path.toFile();
            Set<String> words = countWords(file);
            words.forEach(w -> {
                Set<File> fileSet = new HashSet<>();
                fileSet.add(file);
                map.merge(w, fileSet, (oldSet, newSet) -> {
                    oldSet.addAll(newSet);
                    return oldSet;
                });
            });
        });
    }

    public static void runCore(BiConsumer<ConcurrentHashMap<String, Set<File>>, Path> action) {
        String dir = "src";
        try {
            ConcurrentHashMap<String, Set<File>> result = new ConcurrentHashMap<String, Set<File>>();
            Files.walk(Path.of(dir))
                    .filter(p -> p.toString().endsWith(".java"))
                    .parallel()
                    .forEach(p -> {
                        action.accept(result, p);
                    });
            result.entrySet().stream().sorted(Comparator.comparingInt(entry -> entry.getValue().size())).forEach(entry -> {
                //System.out.println("-----------------------------------------------------------------------------------------------");
                System.out.printf("The word [%s] was found in %d files.%n", entry.getKey(), entry.getValue().size());
//                for (File file : entry.getValue()) {
//                    System.out.println(file.toString());
//                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Set<String> countWords(File file) {
        HashSet<String> words = new HashSet<>();
        try(Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter("\\PL+");
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
        } catch (IOException e) {

        }
        return words;
    }
}
