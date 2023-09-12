package ch03.e11;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Objects;
import java.util.Scanner;

public class E11 {
    public static void run() {
        System.out.print("Input a path to list: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        System.out.print("Input an extension name to filter: ");
        String ext = scanner.nextLine();
        System.out.println("--------------list--------------");
        for (String name : list(path, ext)) {
            System.out.println(name);
        }
        System.out.println("--------------listByLambda--------------");
        for (String name : listByLambda(path, ext)) {
            System.out.println(name);
        }
    }

    public static String[] list(String path, String extensionName) {
        Objects.requireNonNull(path);
        File file = new File(path);
        return file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(extensionName);
            }
        });
    }

    public static String[] listByLambda(String path, String extensionName) {
        Objects.requireNonNull(path);
        File file = new File(path);
        return file.list((dir, name) -> {
            return name.endsWith(extensionName);
        });
    }
}
