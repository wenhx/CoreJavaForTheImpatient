package ch05.e10;

public class E10 {
    public static void run() {
        int n = 10;
        System.out.println();
        System.out.println("factorial(" + n + ") = " + factorial(n));
    }

    public static int factorial(int n) {
        if ((n == 0) || (n == 1))
            return  1;

        printStackFrames(n);
        return  n * factorial(n - 1);
    }

    private static void printStackFrames(int n) {
        Exception ex = new Exception();
        System.out.println(n + " -------------------------------- " + n + " ------------------------------- " + n);
        ex.printStackTrace(System.out);
    }
}
