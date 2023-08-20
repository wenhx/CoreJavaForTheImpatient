package ch01;

import java.util.Scanner;

public class E08 {
    public static void Run() {
        System.out.println("Input a string containing spaces, then press enter.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] result = input.split(" ");
        for (String str : result) {
            System.out.println(str);
        }
    }
}
