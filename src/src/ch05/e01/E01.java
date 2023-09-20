package ch05.e01;

import java.io.*;
import java.util.ArrayList;

public class E01 {
    public static void run() {
        try {
            for (Double n : readValues("src\\ch05\\e01\\E01.txt")) {
                System.out.println(n);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static ArrayList<Double> readValues(String filename) throws IOException {
        ArrayList<Double> list = new ArrayList<>();
        File file = new File(filename);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            double number = Double.valueOf(line);
            list.add(number);
        }
        reader.close();
        return list;
    }
}
