package ch08.e12;

import java.util.Iterator;
import java.util.stream.Stream;

public class E12 {
    public static void run() {
        Stream<Integer> stream1 = Stream.of(1, 3, 5, 7, 9);
        Stream<Integer> stream2 = Stream.of(2, 4, 6, 8, 10, 12, 14, 16, 18, 20);
        zip(stream1, stream2).forEach(System.out::println);
        System.out.println("-------------------------------------------------------------");
        Stream<Integer> stream3 = Stream.of(1, 3, 5, 7, 9);
        Stream<Integer> stream4 = Stream.of(2, 4, 6, 8, 10, 12, 14, 16, 18, 20);
        zip(stream4, stream3).forEach(System.out::println);
        System.out.println("-------------------------------------------------------------");
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> iterator1 = first.iterator();
        Iterator<T> iterator2 = second.iterator();

        Stream.Builder<T> builder = Stream.builder();
        boolean isFirstStreamTurn = true;
        while (iterator1.hasNext() || iterator2.hasNext()) {
            T element;
            if (isFirstStreamTurn) {
                element = iterator1.hasNext() ? iterator1.next() : null;
            } else {
                element = iterator2.hasNext() ? iterator2.next() : null;
            }
            builder.add(element);
            isFirstStreamTurn = !isFirstStreamTurn;
        }

        return builder.build();
    }
}