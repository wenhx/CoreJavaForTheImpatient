package ch04.e10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class E10 {
    public static void run() {
        Class<?> c1 = int[].class;
        while (c1 != null) {
            for (Method m : c1.getDeclaredMethods()) {
                System.out.println(Modifier.toString(m.getModifiers()) + " " +
                        m.getReturnType().getCanonicalName() + " " +
                        m.getName() + Arrays.toString(m.getParameters()));
            }
            c1 = c1.getSuperclass();
        }
    }
}
