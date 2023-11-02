package ch08.e08;

import ch08.e06.E06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E08 {
    private static Set<Integer> VOWELS = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').stream()
            .map(c -> (int)c).collect(Collectors.toSet());

    public static void run() {
        String filePath = "src\\ch08\\e07\\chapter9.txt";
        File file = new File(filePath);
        try {
            Scanner scanner = new Scanner(file);
            List<String> list = Stream.iterate("", str -> scanner.hasNext(), str -> scanner.next()).filter(
                    str -> E06.isWord(str) && containsFiveVowels(str)).collect(Collectors.toList());
            System.out.printf("There are %d words contains 5 vowels.%n", list.size());
            for (String s : list) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean containsFiveVowels(String str) {
        return str.chars().distinct().filter(ch -> VOWELS.contains(ch)).count() == 5;
    }
}
