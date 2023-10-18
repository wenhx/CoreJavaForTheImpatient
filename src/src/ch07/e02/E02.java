package ch07.e02;

import java.util.ArrayList;
import java.util.Iterator;

public class E02 {
    public static void run() {
        ArrayList<String> strings1 = buildStrings();
        ArrayList<String> upper1 = toUpper1(strings1);
        printStrings(upper1);
        ArrayList<String> upper2 = toUpper2(strings1);
        printStrings(upper2);
        ArrayList<String> upper3 = toUpper3(strings1);
        printStrings(upper3);
    }

    private static void printStrings(ArrayList<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("-------------------------");
    }

    static ArrayList<String> buildStrings() {
        ArrayList<String> result = new ArrayList<>();
        result.add("one");
        result.add("two");
        result.add("three");
        result.add("four");
        result.add("five");
        return result;
    }

    static ArrayList<String> toUpper1(ArrayList<String> list) {
        assert list != null;
        ArrayList<String> result = new ArrayList<>(list.size());
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next().toUpperCase();
            result.add(str);
        }
        return result;
    }

    static ArrayList<String> toUpper2(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).toUpperCase());
        }
        return list;
    }

    static ArrayList<String> toUpper3(ArrayList<String> list) {
        list.replaceAll(str -> str.toUpperCase());
        return list;
    }
}
