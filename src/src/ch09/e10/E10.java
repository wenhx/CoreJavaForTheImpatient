package ch09.e10;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E10 {
    public static void run() {
        String str = "1234 is a number. +10 is a number, so does -189. 10086 also is a number. + is a delimiter. - ";
        extractByFind(str).forEach(System.out::println);
        seperate();
        extractBySplit(str).forEach(System.out::println);
    }

    private static ArrayList<Integer> extractBySplit(String str) {
        String regex = "(?<!\\d)[-+](?!\\d)|[^-\\d]+"; // by ChatGPT-4
        Pattern pattern = Pattern.compile(regex);
        String[] results = pattern.split(str);
        ArrayList<Integer> list = new ArrayList<>();
        for (String result : results) {
            if (result.isEmpty())
                continue;;

            list.add(Integer.valueOf(result));
        }
        return list;
    }

    private static void seperate() {
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public static ArrayList<Integer> extractByFind(String str) {
        String regex = "-?\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        ArrayList<Integer> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(Integer.valueOf(matcher.group()));
        }
        return list;
    }
}
