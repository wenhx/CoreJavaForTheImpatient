package ch03.e01;

import java.util.Objects;
import java.util.Random;

public class E01 {
    public static void run() {
        Random random = new Random();
        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new Employee(random.nextDouble());
        }

        double average = average(employees);
        System.out.printf("The average is %g", average);
    }

    public static double average(Measurable[] objects) {
        Objects.requireNonNull(objects);
        if (objects.length == 0)
            return 0;

        double total = 0;
        for (Measurable object : objects) {
            total += object.getMeasure();
        }
        return total / objects.length;
    }
}
