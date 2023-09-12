package ch03.e10;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class E10 {
    public static void run() {
        System.out.print("Input a directory to list: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        System.out.println("------------getSubdirectories---------------");
        for (String subdirectory : getSubdirectories(path)) {
            System.out.println(subdirectory);
        }
        System.out.println("------------getSubdirectoriesByLambda-------------");
        for (String subdirectory : getSubdirectoriesByLambda(path)) {
            System.out.println(subdirectory);
        }
    }

    public static String[] getSubdirectories(String path) {
        Objects.requireNonNull(path);
        File file = new File(path);
        return Arrays.stream(file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        })).map(e -> e.getName()).toArray(String[]::new);
    }

    public static String[] getSubdirectoriesByLambda(String path) {
        Objects.requireNonNull(path);
        File file = new File(path);
        return Arrays.stream(file.listFiles(e -> e.isDirectory())).map(e -> e.getName()).toArray(String[]::new);
    }
}
