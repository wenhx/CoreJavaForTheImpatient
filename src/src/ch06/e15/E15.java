package ch06.e15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;

public class E15 {
    public static void run() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        ArrayList<String> result = map(list, new Function<Number, String>() {

            @Override
            public String apply(Number number) {
                return number.toString();
            }
        });
        System.out.println(Arrays.toString(result.toArray()));
    }

    public static <T, R> ArrayList<R> map(ArrayList<T> list, Function<? super T, ? extends R> func) {
        Objects.requireNonNull(list);
        Objects.requireNonNull(func);
        ArrayList<R> result = new ArrayList<>();
        for (T t : list) {
            R r = func.apply(t);
            result.add(r);
        }
        return result;
    }
}
