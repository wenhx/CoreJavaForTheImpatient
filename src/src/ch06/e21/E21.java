package ch06.e21;

import java.util.List;

public class E21 {
    public static void run() {
        List<String>[] result = Arrays.construct(10);
        System.out.println(result.getClass());
        System.out.println(result.getClass().getComponentType());
    }
}
