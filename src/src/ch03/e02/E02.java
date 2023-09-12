package ch03.e02;

import ch03.e01.Measurable;

import java.util.Objects;
import java.util.Random;

public class E02 {
    public static void run() {
        Random random = new Random();
        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new Employee("User" + i, random.nextDouble() * 100000);
        }

        Employee employeeWithLargestSalary = (Employee) largest(employees);
        System.out.printf("User %s has the largest salary %g", employeeWithLargestSalary.getName(), employeeWithLargestSalary.getMeasure());
    }

    public static Measurable largest(Measurable[] objects) {
        Objects.requireNonNull(objects);
        Measurable largest = null;
        for (Measurable object : objects) {
            if (largest == null) {
                largest = object;
            } else {
                if (object.getMeasure() > largest.getMeasure()) {
                    largest = object;
                }
            }
        }
        return largest;
    }
}
