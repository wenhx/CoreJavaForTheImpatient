package ch03.e15;

import java.util.Random;

public class E15 {
    private static Random generator = new Random();

    public static void run() {
        IntSequence intSequence = randomInts(100, 200);
        for (int i = 0; i < 10; i++) {
            System.out.println(intSequence.next());
        }
    }

    public static IntSequence randomInts(int low, int high) {
        RandomSequence randomSequence = new RandomSequence();
        randomSequence.low = low;
        randomSequence.high = high;
        return randomSequence;
    }

    static class RandomSequence implements IntSequence {
        private int low;
        private int high;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public int next() {
            return low + generator.nextInt(high - low + 1);
        }
    }
}
