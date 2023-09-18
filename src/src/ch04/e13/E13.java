package ch04.e13;

import java.lang.reflect.Method;
import java.util.function.DoubleFunction;

public class E13 {
    public static void run() {
        PrintUsingMethod();
        PrintUsingDoubleFunction();
    }

    private static void PrintUsingDoubleFunction() {
        System.out.println("PrintUsingDoubleFunction");
        printWithDoubleFunction(d -> Math.sqrt(d), 1, 20, 2);
        printWithDoubleFunction(d -> Double.toHexString(d), 1, 30, 3);
    }

    private static void PrintUsingMethod() {
        System.out.println("PrintUsingMethod");
        try {
            Method sqrt = Math.class.getMethod("sqrt", double.class);
            PrintUsingMethod(sqrt, 1, 20, 2);
            Method toHexString = Double.class.getMethod("toHexString", double.class);
            PrintUsingMethod(toHexString, 1, 30, 3);
        } catch (NoSuchMethodException e) {
            System.out.println(e);
        }
    }

    public static void PrintUsingMethod(Method method, double lower, double upper, double step) {
        System.out.println("------------------------------------");
        System.out.printf("|          n | %17s(n) |%n", method.getName());
        for (double n = lower; n < upper; n = n + step) {
            Object result;
            try {
                result = method.invoke(null, n);
            } catch (Exception e) {
                result = e.getMessage();
            }
            System.out.printf("| %10.1f | %20s |%n", n, result.toString());
        }
        System.out.println("------------------------------------");
    }

    public static void printWithDoubleFunction(DoubleFunction<Object> method, double lower, double upper, double step) {
        System.out.println("------------------------------------");
        System.out.printf("|          n | %17s(n) |%n", "result");
        for (double n = lower; n < upper; n = n + step) {
            Object result;
            try {
                result = method.apply(n);
            } catch (Exception e) {
                result = e.getMessage();
            }
            System.out.printf("| %10.1f | %20s |%n", n, result.toString());
        }
        System.out.println("------------------------------------");
    }
}
