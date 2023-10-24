package ch08.e10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E10 {
    public static void run() {
        String filePath = "src\\ch08\\e07\\chapter8.txt";
        File file = new File(filePath);
        try {
            Scanner scanner = new Scanner(file);
            Stream<String> stream = Stream.iterate("", str -> scanner.hasNext(), str -> scanner.next());
            Map.Entry<Integer, List<String>> wordsHavaLongestLength = stream.collect(
                    Collectors.groupingBy(String::length))
                    .entrySet().stream()
                    .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                    .collect(Collectors.toList()).get(0);
            System.out.println("The length of the longest words is: " + wordsHavaLongestLength.getKey());
            wordsHavaLongestLength.getValue().forEach(System.out::println);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
