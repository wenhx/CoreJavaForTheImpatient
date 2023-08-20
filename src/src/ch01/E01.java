package ch01;

import java.util.Scanner;

public class E01 {
    public static void Run() {
        System.out.println("Chapter 1 exercise 1.");
        System.out.print("Please input a number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.printf("The number %d is equal to binary %s, octal %o, and hexadecimal %x.",
                number, Integer.toBinaryString(number), number, number);
    }
}