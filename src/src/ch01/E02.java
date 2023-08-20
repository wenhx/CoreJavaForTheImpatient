package ch01;

import java.util.Scanner;

public class E02 {
    public static void Run() {
        System.out.println("Chapter 1 exercise 2.");
        System.out.print("Pleas input a number: ");
        Scanner scanner = new Scanner(System.in);
        int number = Math.abs(scanner.nextInt());
        int result = number % 359;
        System.out.printf("The result is %d by %%.", result);
        System.out.println();
        int result2 = Math.floorMod(number, 359);
        System.out.printf("The result is %d by Math.fllorMod.", result);
    }
}