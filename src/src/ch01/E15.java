package ch01;

import java.util.ArrayList;
import java.util.Scanner;

public class E15 {
    public static void Run() {
        System.out.print("Input a number: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 1) {
            System.out.println("Number is must greater than 0.");
            return;
        }

        ArrayList<ArrayList<Integer>> pascalTriangle = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> currentRow = new ArrayList<>();
            if (i == 1) {
                currentRow.add(1);
            } else if (i == 2) {
                currentRow.add(1);
                currentRow.add(1);
            } else {
                ArrayList<Integer> previousRow = pascalTriangle.get(i - 1 - 1);
                for (int j = 1; j <= i; j++) {
                    if (j == 1) {
                        currentRow.add(1);
                    } else if (j == i) {
                        currentRow.add(1);
                    } else {
                        currentRow.add(previousRow.get(j - 1 -1) + previousRow.get(j - 1));
                    }
                }
            }
            pascalTriangle.add(currentRow);
        }

        for (int i = 0; i < pascalTriangle.size(); i++) {
            ArrayList<Integer> row = pascalTriangle.get(i);
            for (int j = i + 1; j < pascalTriangle.size(); j++) {
                System.out.print("  ");
            }
            for (Integer num: row) {
                System.out.printf("%3d ", num);
            }
            System.out.println();
        }
    }
}
