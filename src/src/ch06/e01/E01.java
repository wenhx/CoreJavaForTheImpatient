package ch06.e01;

public class E01 {
    public static void run() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        for (int i : stack) {
            System.out.println(i);
        }
        int n = stack.pop();
        System.out.println(n);
        for (int i : stack) {
            System.out.println(i);
        }
    }
}
