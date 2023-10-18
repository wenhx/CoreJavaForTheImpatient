package ch07.e15;

public class E15 {
    public static void run() {
        ImmutableIntFunctionList<String> numberToString = new ImmutableIntFunctionList<>(n -> new Integer(n).toString());
        System.out.println(numberToString.get(Integer.MIN_VALUE));
        System.out.println(numberToString.get(Integer.MAX_VALUE));
        ImmutableIntFunctionList<Integer> squareList = new ImmutableIntFunctionList<>(n -> n * n);
        for (int i = 0; i < 10; i++) {
            System.out.println(squareList.get(i));
        }
    }
}
