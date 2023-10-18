package ch07.e01;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class E01 {
    public static void run() {
        for (Integer prime : getPrimeNumbers(100)) {
            System.out.print(prime + ", ");
        }
    }

    public static Set<Integer> getPrimeNumbers(int limit) {
        Set<Integer> set = new HashSet<>();
        BitSet bitSet = new BitSet();
        for (int i = 2; i < limit; i++) {
            set.add(i);
            bitSet.set(i, true);
        }
        for (Integer i : set) {
            for (int j = 2; j < (limit / i) + 1; j++) {
                int number = i * j;
                System.out.println(number);
                bitSet.set(number, false);
            }
        }
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            if (!bitSet.get(element)) {
                iterator.remove();
            }
        }
        return set;
    }
}
