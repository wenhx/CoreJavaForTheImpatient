package ch04.e11;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class E11 {
    public static void run() {
        try {
            Class<?> c1 = Class.forName("java.lang.System");
            Field outField = c1.getField("out");
            Object out = outField.get(null);
            Class<?> c2 = Class.forName("java.io.PrintStream");
            Method printlnMethod = c2.getMethod("println", String.class);
            printlnMethod.invoke(out, "Hello World!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
