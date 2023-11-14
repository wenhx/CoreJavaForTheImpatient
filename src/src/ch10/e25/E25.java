package ch10.e25;

import java.net.PasswordAuthentication;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class E25 {
    public static void run() {
        repeat(E25::readPassword, E25::checkPassword)
                .thenAccept(auth -> System.out.println(auth.getUserName() + "!"))
                .join();
    }

    public static <T> CompletableFuture<T> repeat(Supplier<T> action, Predicate<T> until) {
        return CompletableFuture.supplyAsync(action).thenApplyAsync(t -> {
            if (until.test(t))
                return t;
            System.out.println("Try again!");
            try {
                return repeat(action, until).get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }

    static PasswordAuthentication readPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Code Word: ");
        String password = scanner.nextLine();
        return new PasswordAuthentication("Open Sesame", password.toCharArray());
    }

    static boolean checkPassword(PasswordAuthentication password) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "secret".equals(new String(password.getPassword()));
    }
}
