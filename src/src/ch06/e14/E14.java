package ch06.e14;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class E14 {
    public static void run() {
        ArrayList<AutoCloseable> autoCloseables = new ArrayList<>();
        autoCloseables.add(BuildAutoCloseable(true));
        autoCloseables.add(BuildAutoCloseable(false));
        autoCloseables.add(BuildAutoCloseable(true));
        autoCloseables.add(BuildAutoCloseable(true));
        autoCloseables.add(BuildAutoCloseable(false));
        try {
            closeAll(autoCloseables);
        } catch (Throwable e) {
            do {
                System.out.println(e.getMessage());
                e = e.getCause();
            } while (e != null);
        }
    }

    private static AutoCloseable BuildAutoCloseable(boolean throwException) {
        return new AutoCloseable() {
            @Override
            public void close() throws Exception {
                Thread.sleep(500);
                String now = LocalDateTime.now().toString();
                if (throwException)
                    throw new Exception(now + " Exception happened when calling close()");
                System.out.println(now + " Calling close()");
            }
        };
    }

    public static <T extends AutoCloseable> void closeAll(ArrayList<T> elems) throws Exception {
        Objects.requireNonNull(elems);
        Exception lastException = null;
        for (T elem : elems) {
            try {
                elem.close();
            } catch (Exception e) {
                if (lastException != null) {
                    e.initCause(lastException);
                }
                lastException = e;
            }
        }
        if (lastException != null)
            throw lastException;
    }
}
