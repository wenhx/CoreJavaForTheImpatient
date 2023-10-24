package ch08.e02;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

public class E02 {
    private static final Random RANDOM = new Random();
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static void run() {
        //In chapter 8, section 1, the term "long word" refers to a word with a length greater than 12.
        int longWordStringLength = 12;
        int longWordCount = 50000000;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < longWordCount; i++) {
            String str = buildString();
            list.add(str);
        }

        runTest(list, l -> l.stream().filter(str -> str.length() > longWordStringLength).count());
        runTest(list, l -> l.parallelStream().filter(str -> str.length() > longWordStringLength).count());
    }

    private static void runTest(ArrayList<String> list, Function<ArrayList<String>, Long> method1) {
        long start = System.currentTimeMillis();
        long count = method1.apply(list);
        long end = System.currentTimeMillis();
        System.out.printf("There are %d long words in this list of %d words.%n", count, list.size());
        System.out.printf("The invoked time is: %dms%n", (end - start));
        System.out.println("-----------------------------------------");
    }

    private static String buildString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < RANDOM.nextInt(50); i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}
