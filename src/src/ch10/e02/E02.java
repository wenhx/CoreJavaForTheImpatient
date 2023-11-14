package ch10.e02;

import java.util.Arrays;
import java.util.Random;

public class E02 {
    public static void run() {
        int arrayLength = 10;
        int step = 10;
        int runTimes = 0;
        int runTimesEachStep = 10;
        while (true) {
            double[] doubles1 = buildArray(arrayLength);
            double[] doubles2 = Arrays.copyOf(doubles1, doubles1.length);
            long pSortTime = runTest(() -> Arrays.parallelSort(doubles1));
            long sortTime = runTest(() -> Arrays.sort(doubles2));
            if (pSortTime >= sortTime) {
                arrayLength += step;
                continue;
            }

            if (runTimes++ < runTimesEachStep)
                continue;

            runTimes = 0;
            //Despite multiple attempts using test results, the outcome remains highly unstable.
            System.out.printf("Length: %d, pSortTime: %dms, sortTime: %dms%n", arrayLength, pSortTime, sortTime);
            break;
        }
    }

    public static long runTest(Runnable action) {
        long start = System.currentTimeMillis();
        action.run();
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static double[] buildArray(int length) {
        double[] arr = new double[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextDouble();
        }
        return arr;
    }
}
