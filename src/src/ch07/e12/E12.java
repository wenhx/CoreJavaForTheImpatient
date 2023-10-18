package ch07.e12;

import java.util.*;
import java.util.regex.Pattern;

public class E12 {
    public static void run() {
        System.out.print("Please input a sentence: ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<String> words = new ArrayList<>(Arrays.asList(line.split("\\W+")));
        printArray(words);
        Collections.shuffle(words);
        Fix(words, line);
        printArray(words);
    }

    private static void Fix(List<String> words, String line) {
        String first = words.get(0);
        char[] chars = first.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        words.set(0,new String(chars));
        char[] chars2 = line.toCharArray();
        String lastChar = chars2[chars2.length - 1] + "";
        if (Pattern.matches("\\p{Punct}", lastChar)) {
            words.add(lastChar);
        } else {
            words.add(".");
        }
    }

    private static void printArray(List<String> words) {
        for (String word : words) {
            System.out.println(word);
        }
        System.out.println("-----------------------------------------------------");
    }
}
