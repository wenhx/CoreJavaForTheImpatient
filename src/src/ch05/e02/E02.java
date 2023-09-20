package ch05.e02;

import ch05.e01.E01;

import java.io.IOException;
import java.util.ArrayList;

public class E02 {
    public static void run() {
        try {
            System.out.println(sumOfValues("src\\ch05\\e02\\E02.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static double sumOfValues(String filename) throws IOException {
        ArrayList<Double> list = E01.readValues(filename);
        double total = 0d;
        for (Double n : list) {
            total += n;
        }
        return total;
    }
}
