package ch05.e11;

import java.util.Objects;

public class E11 {
    public static void run() {

    }

    public static int factorial(Integer n) {
        Objects.requireNonNull(n);
        if (n < 0)
            throw new IllegalArgumentException("The parameter n must be greater than or equal to 0.");

        if ((n == 0) || (n == 1))
            return  1;

        assert n >= 2 : n + "is less than 2.";
        return  n * factorial(n - 1);
    }
}
