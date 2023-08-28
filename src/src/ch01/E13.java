package ch01;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class E13 {
    public static void run() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int n = 0; n < 5; n++) {
            int[] numbers = new int[6];
            for (int i = 0; i < 6; i++) {
                int number = random.nextInt(49);
                numbers[i] = number;
            }
            Arrays.sort(numbers);
            StringBuilder sb = new StringBuilder();
            for (int number : numbers) {
                sb.append(number);
                sb.append(' ');
            }
            System.out.println(sb.toString());
        }
    }
}
