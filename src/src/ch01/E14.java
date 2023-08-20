package ch01;

import java.util.ArrayList;
import java.util.Scanner;

public class E14 {
    public static void Run() {
        ArrayList<int[]> list = new ArrayList<>();
        System.out.println("Please input numbers separated by spaces. End with blank line.");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            if (line.isEmpty())
                break;

            String[] numberStrings = line.split(" ");
            int[] row = new int[numberStrings.length];
            for (int i = 0; i < numberStrings.length; i++) {
                row[i] = Integer.parseInt(numberStrings[i]);
            }

            list.add(row);
        }

        int previousColumnCount = 0;
        int previousSum = 0;
        for (int[] ints : list) {
            if (previousColumnCount == 0) {
                previousColumnCount = ints.length;
            } else {
                if (previousColumnCount != ints.length) {
                    System.out.println("The input is not a magic square. 1");
                    return;
                }
            }
            int total = 0;
            for (int n : ints) {
                total += n;
            }
            if (previousSum == 0) {
                previousSum = total;
            } else {
                if (previousSum != total) {
                    System.out.println("The input is not a magic square. 2");
                    return;
                }
            }
        }

        if (list.size() != previousColumnCount) {
            System.out.println("The input is not a magic square. 3");
            return;
        }
        for (int i = 0; i < previousColumnCount; i++) {
            int total = 0;
            for (int j = 0; j < list.size(); j++) {
                total += list.get(j)[i];
            }
            if (total != previousSum) {
                System.out.println("The input is not a magic square. 4");
                return;
            }
        }

        int diagonalSum1 = 0;
        int diagonalSum2 = 0;
        for (int i = 0; i < previousColumnCount; i++) {
            diagonalSum1 += list.get(i)[i];
            diagonalSum2 += list.get(i)[previousColumnCount - (i + 1)];
        }
        if (diagonalSum1 != previousSum || diagonalSum2 != previousSum) {
            System.out.println("The input is not a magic square. 5");
        }
        else {
            System.out.println("The input is a magic square.");
        }
    }
}
