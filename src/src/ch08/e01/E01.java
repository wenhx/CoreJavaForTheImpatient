package ch08.e01;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class E01 {
    private static final Random RANDOM = new Random();
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static void run() {
        //In chapter 8, section 1, the term "long word" refers to a word with a length greater than 12.
        int longWordStringLength = 12;
        int longWordCount = 0;
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            String str = buildString();
            list.add(str);
            if (str.length() > longWordStringLength) {
                longWordCount++;
            }
        }
        System.out.printf("There are %d long words in this list of %d words.%n", longWordCount, list.size());
        int theNumberOflongWordShoudTake = 3;
        AtomicInteger times = new AtomicInteger(1);
        Object[] array = list.stream().filter(str -> {
                    System.out.printf("The %d times call.%n", times.getAndIncrement());
                    return str.length() > longWordStringLength;
                })
                .limit(theNumberOflongWordShoudTake).toArray();
        long count = array.length;
        System.out.println("The count is " + count);
        for (Object o : array) {
            System.out.println(o);
        }
    }

    private static String buildString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < RANDOM.nextInt(50); i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}
