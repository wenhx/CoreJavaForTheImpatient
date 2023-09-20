package ch05.e04;

import java.io.*;
import java.util.ArrayList;

public class E04 {
    public static void run() {
        System.out.println(sumOfValues("src\\ch05\\e02\\E02.txt"));
        System.out.println(sumOfValues("src\\ch05\\e01\\E01.txt"));
    }

    public static InvokedResult<ArrayList<Double>> readValues(String filename) {
        ArrayList<Double> list = new ArrayList<>();
        File file = new File(filename);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                double number = Double.valueOf(line);
                list.add(number);
            }
        } catch (IOException | NumberFormatException ex) {
            return new InvokedResult<>(1, list);
        }
        return new InvokedResult<>(list);
    }

    public static InvokedResult<Double> sumOfValues(String filename) {
        InvokedResult<ArrayList<Double>> result = readValues(filename);
        if (!result.IsSucceeded())
            return new InvokedResult<>(result.getErrorCode(), null);

        ArrayList<Double> list = result.getResult();
        double total = 0d;
        for (Double n : list) {
            total += n;
        }
        return new InvokedResult<>(total);
    }
}