package ch05.e05;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class E05 {
    public static void run() {
        lowerCaseFile();
    }
    public static void lowerCaseFile() {
        Scanner in = null;
        PrintWriter out = null;
        try {
            in = new Scanner(Paths.get("src\\ch05\\e01\\E01.txt"));
            out = new PrintWriter("out.txt");
            while (in.hasNext())
                out.println(in.next().toLowerCase());
            in.close();
            out.close();
        } catch (IOException ex) {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            ex.printStackTrace();
        }
    }
}