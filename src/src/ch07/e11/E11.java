package ch07.e11;

import java.util.*;

public class E11 {
    public static void run() {
        System.out.print("Please input a sentence: ");
        Scanner scanner = new Scanner(System.in);
        List<String> words = Arrays.asList(scanner.nextLine().split("\\W+"));
        printArray(words);
        Collections.shuffle(words.subList(1, words.size() - 1));
        printArray(words);
    }

    private static void printArray(List<String> words) {
        for (String word : words) {
            System.out.println(word);
        }
        System.out.println("-----------------------------------------------------");
    }
}
