package ch06.e23;

import java.util.concurrent.Callable;

public class E23 {
    public static void run() {
        try {
            System.out.println(doWork(() -> Class.forName("Test class name").toString()));
        } catch (Exception ex) {
            System.out.println(ex.getClass());
        }
    }

    public static <T extends  Throwable> void throwAs(Throwable e) throws T {
        throw (T) e; //This works.
        //throw (RuntimeException)e; // This doesn't work. It will throw a ClassCastException sometimes, because the type of e is not always RuntimeException.
    }

    public static <V> V doWork(Callable<V> c) {
        try {
            return c.call();
        } catch (Throwable ex) {
            E23.throwAs(ex);
            return null;
        }
    }
}
