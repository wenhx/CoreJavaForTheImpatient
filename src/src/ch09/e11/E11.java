package ch09.e11;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E11 {
    public static void run() {
        Arrays.stream(extract("/home/cay/myfile.txt")).forEach(System.out::println);
        System.out.println();
        Arrays.stream(extract("C:\\user\\home\\cay\\myfile.txt")).forEach(System.out::println);
    }

    public static String[] extract(String path) {
        String regex = "(?<path>.*[\\/\\\\])(?<fileName>[-_\\w]*)\\.(?<extName>\\w+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(path);
        if (matcher.matches()) {
            String[] result = new String[3];
            result[0] = matcher.group("path");
            result[1] = matcher.group("fileName");
            result[2] = matcher.group("extName");
            return result;
        }
        return new String[0];
    }
}
