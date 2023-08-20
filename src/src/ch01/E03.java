package ch01;

import java.util.Scanner;

public class E03 {
    public static void Run() {
        System.out.println("Chapter 1 exercise 3.");
        System.out.print("Please input 3 numbers separated by spaces: ");
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        int number3 = scanner.nextInt();
        int result = Integer.MIN_VALUE;
        if (number1 > number2) {
            result = number1;
        } else {
            result = number2;
        }
        if (result < number3) {
            result = number3;
        }
        System.out.printf("The largest of these 3 numbers is %d.(method 1)", result);
        System.out.println();
        int result2 = Math.max(number1, number2);
        result2 = Math.max(result2, number3);
        System.out.printf("The largest of these 3 numbers is %d.(method 2)", result2);
    }
}
