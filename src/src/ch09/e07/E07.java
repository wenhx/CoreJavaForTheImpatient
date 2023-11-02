package ch09.e07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class E07 {
    public static void run() {
        try {
            String sample = "src\\ch09\\e07\\sample.txt";
            byte[] bytes = Files.readAllBytes(Path.of(sample));
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(bytes);
            byte[] result = md.digest();
            String sha1Result = bytesToHex(result);
            System.out.println(sha1Result);
            System.out.println("8229E877A9E939EE2ACD968A69CD65B4D32CE89E".equals(sha1Result));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String bytesToHex(byte[] byteArray) {
        StringBuilder sb = new StringBuilder();
        for (byte b : byteArray) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}
