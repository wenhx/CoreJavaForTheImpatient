package ch10.e15;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E15 {
    public static void run() {
        String dir = "src";
        try {
            HashMap<String, Integer> counter = Files.walk(Path.of(dir))
                    .map(Path::toFile)
                    .filter(f -> f.isFile() && f.toString().endsWith(".java"))
                    .parallel()
                    .map(f -> {
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
                    })
                    .reduce(new HashMap<String, Integer>(), E15::mergeMap, E15::mergeMap);

            System.out.println("There are " + counter.size() + " different words.");
            System.out.println("------------------------------------------------------");
            System.out.println("The ten most common words:");

            counter.entrySet().stream()
                    .sorted(Comparator.comparingInt(e -> -e.getValue()))
                    .limit(10)
                    .forEach(System.out::println);
            System.out.println("Done!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static HashMap<String, Integer> mergeMap(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        HashMap<String, Integer> result = new HashMap<>(map1);
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            result.compute(entry.getKey(), (key, value) -> value == null ? entry.getValue() : value + entry.getValue());
        }
        return result;
    }
}
