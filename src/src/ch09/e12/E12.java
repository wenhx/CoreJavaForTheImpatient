package ch09.e12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E12 {
    public static void run() {
        replaceAll("Th234234is is234 a se332349nten4ce with s5ome number10.", "\\d+", "");
        replaceAll("Allll reeepeated lettttters willll beee replaced with...", "(\\w)\\1+", "...");
    }

    private static void replaceAll(String input, String regex, String replacement) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        String result = matcher.replaceAll(replacement);
        System.out.println(result);
    }
}
