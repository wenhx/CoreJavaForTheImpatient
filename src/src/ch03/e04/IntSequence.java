package ch03.e04;

public interface IntSequence {
    boolean hasNext();
    int next();

    public static IntSequence of(int... args) {
        return new IntSequence() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < args.length;
            }

            @Override
            public int next() {
                if (index >= args.length)
                    throw new IndexOutOfBoundsException();

                return args[index++];
            }
        };
    }
}
