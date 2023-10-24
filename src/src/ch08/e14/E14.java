package ch08.e14;

import java.util.stream.Stream;

public class E14 {
    public static void run() {
        double average1 = BuildStream().reduce(new AverageAccumulator(0, 0),
                (avg, number) -> avg.add(number),
                (avg1, avg2) -> avg1.add(avg2)).getAverage();
        double average2 = BuildStream().mapToDouble(Double::doubleValue).average().getAsDouble();
        System.out.println(average1 == average2);
    }

    private static Stream<Double> BuildStream() {
        return Stream.of(1d, 2d, 3d, 4d, 5d, 6d, 7d, 8d, 9d, 10d);
    }
}
