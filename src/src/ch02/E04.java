package ch02;

import org.omg.CORBA.IntHolder;

import java.util.Scanner;

public class E04 {
    public static void run() {
        System.out.print("Input 2 numbers: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.printf("Numbers before swap: %d %d%n", n, m);
        swapInt(n, m);
        System.out.printf("Numbers after swapInt: %d %d%n", n, m);
        IntHolder nIntHolder = new IntHolder(n);
        IntHolder mIntHolder = new IntHolder(m);
        swapIntHolder(nIntHolder, mIntHolder);
        System.out.printf("Numbers after swapIntHolder: %d %d%n", nIntHolder.value, mIntHolder.value);
        Integer nInteger = new Integer(n);
        Integer mInteger = new Integer(m);
        swapInteger(nInteger, mInteger);
        System.out.printf("Numbers after swapInteger: %d %d%n", nInteger, mInteger);
    }

    public static void swapInt(int a, int b) {
        int tmp = a;
        b = a;
        a = tmp;
    }

    public static void swapIntHolder(IntHolder a, IntHolder b) {
        int tmp = a.value;
        a.value = b.value;
        b.value = tmp;
    }

    public static void swapInteger(Integer a, Integer b) {
        Integer tmp = a;
        a = b;
        b = tmp;
    }
}
