package ch08.e13;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class E13 {
    public static void run() {
        ArrayList<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 4));
        ArrayList<Integer> list2 = new ArrayList<>(List.of(5, 6, 7, 8));
        runCore(E13::join, list1, list2);
        runCore(E13::join2, list1, list2);
        runCore(E13::join3, list1, list2);
    }

    private static <T> void runCore(Function<Stream<ArrayList<T>>, ArrayList<T>> func, ArrayList<T> list1, ArrayList<T> list2) {
        ArrayList<T> joined = func.apply(Stream.of(list1, list2));
        joined.forEach(System.out::println);
        System.out.println("-----------------------------------------------------------");
    }

    public static <T> ArrayList<T> join(Stream<ArrayList<T>> stream) {
        Optional<ArrayList<T>> result = stream.reduce(E13::add);
        return result.isPresent() ? result.get() : new ArrayList<T>();
    }

    public static <T> ArrayList<T> join2(Stream<ArrayList<T>> stream) {
        return stream.reduce(new ArrayList<>(), E13::add);
    }

    public static <T> ArrayList<T> join3(Stream<ArrayList<T>> stream) {
        return stream.reduce(new ArrayList<>(), E13::add, E13::add);
    }

    public static <T> ArrayList<T> add(ArrayList<T> l1, ArrayList<T> l2) {
        ArrayList<T> list = new ArrayList<>(l1);
        list.addAll(l2);
        return list;
    }
}
