package ch08.e07;

import ch08.e06.E06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E07 {
    public static void run() {
        String filePath = "src\\ch08\\e07\\chapter9.txt";
        File file = new File(filePath);
        listFirst100Tokens(file);
        System.out.println("---------------------------------------------------------");
        list10MostFrequentWords(file);
    }

    private static void list10MostFrequentWords(File file) {
        try {
            final Scanner scanner = new Scanner(file);
            Stream<String> stream = Stream.iterate("", str -> scanner.hasNext(), str -> scanner.next());
            Map<String, Long> counts = stream.filter(str -> E06.isWord(str)).collect(Collectors.groupingBy(str -> str.toLowerCase(), Collectors.counting()));
            counts.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(20).forEach(System.out::println);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void listFirst100Tokens(File file) {
        try {
            final Scanner scanner = new Scanner(file);
            Stream<String> stream = Stream.iterate("", str -> scanner.hasNext(), str -> scanner.next());
            stream.filter(str -> E06.isWord(str)).limit(100).forEach(System.out::println);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}