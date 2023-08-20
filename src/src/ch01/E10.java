package ch01;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class E10 {
    public static void Run() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        char[] seeds = "0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            long number = random.nextLong(Long.MAX_VALUE);
            int index = (int)(number % seeds.length);
            System.out.printf("number: %d, index: %d%n", number, index);
            sb.append(seeds[index]);
        }
        System.out.printf("result is: %s", sb.toString());
    }
}
