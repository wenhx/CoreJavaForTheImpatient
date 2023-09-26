package ch06.e02;

public class E02 {
    public static void run() {
        runStack1();
        runStack2();
    }

    private static void runStack1() {
        System.out.println("------------------Stack 1-----------------------------");
        Stack<Integer> stack1 = new Stack<>(Integer[]::new);
        for (int i = 0; i < 10; i++) {
            stack1.push(i);
        }
        for (Integer i : stack1) {
            System.out.println(i);
        }
        System.out.println("-----------------------------------------------");
        while (!stack1.isEmpty()) {
            System.out.println(stack1.pop());
        }
        System.out.println("-----------------------------------------------");
    }

    private static void runStack2() {
        System.out.println("------------------Stack 2-----------------------------");
        Stack2<Integer> stack2 = new Stack2<>();
        for (int i = 0; i < 10; i++) {
            stack2.push(i);
        }
        for (Integer i : stack2) {
            System.out.println(i);
        }
        System.out.println("-----------------------------------------------");
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop());
        }
        System.out.println("-----------------------------------------------");
    }
}
