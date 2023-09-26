package ch06.e22;

import java.util.concurrent.Callable;
import java.util.function.Function;

public class E22 {
    public static void run() {
        try {
            Class<?> c = doWork(() -> {
                return Class.forName("java.lang.String");
            }, Exception::new);
            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <V, T extends Throwable> V doWork(Callable<V> c, Function<Throwable, T> ctor) throws T {
        try {
            return c.call();
        } catch (Throwable realEx) {
            throw ctor.apply(realEx);
        }
    }
}
