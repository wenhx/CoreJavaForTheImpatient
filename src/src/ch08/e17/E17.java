package ch08.e17;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class E17 {
    public static void run() {
        runCore(UnaryOperator.identity());
        System.out.println("-------------------------------------------------------");
        //Does not work properly in parallel mode
        runCore(s -> s.parallel());
    }

    private static void runCore(UnaryOperator<Stream<Integer>> operator) {
        Stream<Integer> stream = operator.apply(buildStream());
        ConcurrentSkipListSet<Integer> set = new ConcurrentSkipListSet<>();
        stream.filter(n -> {
            if (set.isEmpty()) {
                set.add(n);
                return true;
            }
            if (set.contains(n))
                return false;
            set.clear();
            set.add(n);
            return true;
        }).collect(Collectors.toList()).forEach(System.out::println);
    }

    private static Stream<Integer> buildStream() {
        return Stream.of(1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2,
                1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2,
                1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2,
                1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2,
                1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 2, 2);
    }
}
