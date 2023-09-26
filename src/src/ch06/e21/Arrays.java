package ch06.e21;

import java.lang.reflect.Array;

public class Arrays {
    @SafeVarargs
    public static <T> T[] construct(int n, T... array) {
        @SuppressWarnings("unchecked")
        T[] result = (T[])Array.newInstance(array.getClass().getComponentType(), n);
        return result;
    }
}
