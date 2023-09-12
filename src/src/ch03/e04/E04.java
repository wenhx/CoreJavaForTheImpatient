package ch03.e04;

public class E04 {
    public static void run() {
        IntSequence sequence = IntSequence.of(1, 2, 3, 4, 5, 6, 7, 8);
        while (sequence.hasNext()) {
            System.out.println(sequence.next());
        }
    }
}
