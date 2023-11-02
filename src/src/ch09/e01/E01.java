package ch09.e01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class E01 {
    public static void run() {
        copyCore(new ByteArrayOutputStream(), E01::copy1, E01::check);
        copyCore(new ByteArrayOutputStream(), E01::copy2, E01::check);
    }

    private static void copyCore(OutputStream out, BiConsumer<InputStream, OutputStream> copyFun, Consumer<OutputStream> check) {
        String file = "src\\ch08\\e07\\chapter9.txt";
        Path path = Path.of(file);
        try (InputStream in = Files.newInputStream(path)) {
            copyFun.accept(in, out);
            check.accept(out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void check(OutputStream out) {
        ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) out;
        System.out.println(byteArrayOutputStream.size());
    }

    public static void copy1(InputStream in, OutputStream out) {
        try {
            byte[] buff = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buff)) != -1) {
                out.write(buff, 0, bytesRead);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void copy2(InputStream in, OutputStream out) {
        try {
            Path tempFile = Files.createTempFile(null, ".txt");
            Files.copy(in, tempFile, StandardCopyOption.REPLACE_EXISTING);
            Files.copy(tempFile, out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
