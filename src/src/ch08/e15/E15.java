package ch08.e15;

import java.math.BigInteger;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class E15 {
    final static long LIMIT = 2000;

    public static void run() {
        BigInteger startPoint = BigInteger.TEN.pow(50);
        runCore(E15::runSerial, startPoint, "Serial: ");
        runCore(E15::runParallel, startPoint, "Parallel: ");
    }

    private static void runCore(Consumer<BigInteger> consumer, BigInteger startPoint, String label) {
        long start = System.currentTimeMillis();
        consumer.accept(startPoint);
        long end = System.currentTimeMillis();
        long executionTime = end - start;
        System.out.println(label + "Execution time: " + executionTime);
        System.out.println("-------------------------------------------------------------");
    }

    public static void runSerial(BigInteger startPoint) {
        Stream.iterate(startPoint, n -> n.add(BigInteger.ONE)).filter(E15::isProbablePrime).limit(LIMIT).count();
    }

    private static void runParallel(BigInteger startPoint) {
        Stream.iterate(startPoint,n -> n.add(BigInteger.ONE)).parallel().filter(E15::isProbablePrime).limit(LIMIT).count();
    }

    private static boolean isProbablePrime(BigInteger bigInteger) {
        return bigInteger.isProbablePrime(100);
    }
}
