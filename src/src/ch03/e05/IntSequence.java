package ch03.e05;

public interface IntSequence {
    default boolean hasNext() {
        return true;
    }
    int next();

    public static IntSequence constant(int seed) {
        return () -> {
            while (true)
                return seed;
        };
    }
}
