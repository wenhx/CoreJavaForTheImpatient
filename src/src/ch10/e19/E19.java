package ch10.e19;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class E19 {
    public static void run() {
        String answer = "src\\ch10\\e19\\answer.txt";
        try {
            System.out.println(Files.readString(Path.of(answer)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
