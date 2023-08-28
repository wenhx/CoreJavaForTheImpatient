package ch01;

import java.util.Scanner;

public class E11 {
    public static void run() {
        System.out.print("Input some words: ");
        Scanner scanner = new Scanner(System.in);
        char[] inputs = scanner.nextLine().toCharArray();
        for (int i = 0; i < inputs.length; i++) {
            char c = inputs[i];
            if (c > 255) {
                System.out.printf("char %c is not a ASCII, Unicode: %d.%n", c, (int)c);
            }
        }
    }
}
