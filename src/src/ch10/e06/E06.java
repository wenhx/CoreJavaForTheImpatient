package ch10.e06;

import ch10.e05.E05;

import java.io.File;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class E06 {
    public static void run() {
        E05.runCore((map, path) -> {
            File file = path.toFile();
            Set<String> words = E05.countWords(file);
            words.forEach(word -> {
                Set<File> fileSet = map.computeIfAbsent(word, w -> {
                    return ConcurrentHashMap.newKeySet();
                });
                fileSet.add(file);
            });
        });
    }
}