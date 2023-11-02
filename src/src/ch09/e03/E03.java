package ch09.e03;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class E03 {
    public static void run() {
        String ascii = "src\\ch09\\e03\\ASCII.txt";
        String iso88591 = "src\\ch09\\e03\\iso8859-1.txt";
        String utf8 = "src\\ch09\\e03\\UTF-8.txt";
        String utf16 = "src\\ch09\\e03\\UTF-16.txt";
        try {
            String template = "The encoding of file %s is %s.%n";
            System.out.printf(template, ascii, guessEncoding(ascii));
            System.out.printf(template, iso88591, guessEncoding(iso88591));
            System.out.printf(template, utf8, guessEncoding(utf8));
            System.out.printf(template, utf16, guessEncoding(utf16));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //The code was written by ChatGPT, but it's not exactly correct.
    // I think this is an industry conundrum that is not suitable as an exercise.
    public static Charset guessEncoding(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        fis.read(bytes);
        fis.close();

        // Check for UTF-8 BOM
        if (bytes.length >= 3 && bytes[0] == (byte) 0xEF && bytes[1] == (byte) 0xBB && bytes[2] == (byte) 0xBF)
            return StandardCharsets.UTF_8;

        // Check for UTF-16 LE BOM
        if (bytes.length >= 2 && bytes[0] == (byte) 0xFF && bytes[1] == (byte) 0xFE) return StandardCharsets.UTF_16LE;

        // Check for UTF-16 BE BOM
        if (bytes.length >= 2 && bytes[0] == (byte) 0xFE && bytes[1] == (byte) 0xFF) return StandardCharsets.UTF_16BE;

        // Assume ASCII as default
        String text = new String(bytes, StandardCharsets.US_ASCII);

        // Check if ASCII assumption is valid
        if (text.codePoints().allMatch(codePoint -> codePoint < 128)) return StandardCharsets.US_ASCII;
        // Otherwise guess ISO 8859-1
        return StandardCharsets.ISO_8859_1;
    }
}
