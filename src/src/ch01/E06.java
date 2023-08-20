package ch01;

import java.math.BigInteger;

public class E06 {
    public static void Run() {
        BigInteger result = BigInteger.ONE;
        int n = 1000;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.printf("The reuslt of 1000! is %s", result.toString());
    }
}
