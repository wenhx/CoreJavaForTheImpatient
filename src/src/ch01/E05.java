package ch01;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class E05 {
    public static void Run() {
        int maxInt = Integer.MAX_VALUE;
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randomInt = random.nextInt(Integer.MAX_VALUE);
        System.out.printf("Random int is %d%n", randomInt);
        double doubleGreaterThenMaxInt = (double) maxInt + randomInt;
        int greaterThenMaxInt = (int)doubleGreaterThenMaxInt;
        System.out.printf("Max int is    %d%n", Integer.MAX_VALUE);
        System.out.printf("The result is %d", greaterThenMaxInt);
    }
}