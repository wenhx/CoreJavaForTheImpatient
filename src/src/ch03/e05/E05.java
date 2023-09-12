package ch03.e05;

public class E05 {
    public static void run() {
        int count = 0;
        IntSequence sequence = IntSequence.constant(8);
        while (sequence.hasNext()) {
            System.out.println(sequence.next());
            if (count++ > 10)
                break;
        }
    }
}
