package ch03.e12;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class E12 {
    public static void run() {
        System.out.print("Input a path to list: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        File file = new File(path);
        File[] files = file.listFiles();
        System.out.println("-------------------Before--------------------");
        list(files);
        System.out.println("-------------------After--------------------");
        Arrays.sort(files, (f1, f2) -> {
            if (f1.isDirectory() && f2.isDirectory())
                return f1.getName().compareTo(f2.getName());
            if (f1.isDirectory())
                return -1;
            if (f2.isDirectory())
                return 1;
            return f1.getName().compareTo(f2.getName());
        });
        list(files);
    }

    private static void list(File[] files) {
        for (File f : files) {
            if (f.isDirectory()) {
                System.out.printf("D %s%n", f.getName());
            } else {
                System.out.println(f.getName());
            }
        }
    }
}
