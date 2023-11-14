package ch10.e01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class E01 {
    public static void run() {
        String dir = "src";
        String word = "E01";
        try {
            findAllFiles(dir, word).forEach(System.out::println);
            System.out.println("--------------------------------------------------");
            System.out.println(findTheFirst(dir, word));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> findAllFiles(String directory, String word) throws IOException {
        return Files.walk(Path.of(directory))
                .parallel()
                .filter(p -> {
                    if (!p.toString().endsWith(".java"))
                        return false;

                    try {
                        return Files.lines(p).anyMatch(l -> lineContainsWord(l, word));
                    } catch (IOException e) {
                        return false;
                    }
                })
                .map(p -> p.toString())
                .collect(Collectors.toList());
    }

    public static String findTheFirst(String directory, String word) throws IOException {
        Optional<Path> first = Files.walk(Path.of(directory))
                .parallel()
                .filter(p -> {
                    if (!p.toString().endsWith(".java"))
                        return false;

                    try {
                        return Files.lines(p).anyMatch(l -> lineContainsWord(l, word));
                    } catch (IOException e) {
                        return false;
                    }
                })
                .findFirst();
        return first.isPresent() ? first.get().toString() : null;
    }

    private static boolean lineContainsWord(String line, String word) {
        return line.matches("(?i).*\\b" + Pattern.quote(word) + "\\b.*");
    }
}
