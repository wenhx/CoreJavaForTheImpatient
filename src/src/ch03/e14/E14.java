package ch03.e14;

import java.util.Arrays;
import java.util.Comparator;

public class E14 {
    public static void run() {
        Employee[] employees = buildEmployees();
        System.out.println("--------------Before--------------");
        print(employees);
        System.out.println("--------------After--------------");
        Arrays.sort(employees, Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName));
        print(employees);
        Arrays.sort(employees, Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary));
        System.out.println("--------------Then--------------");
        print(employees);
    }

    public static Employee[] buildEmployees() {
        Employee[] result = new Employee[10];
        result[0] = new Employee("User A", 1000);
        result[1] = new Employee("User B", 1000);
        result[2] = new Employee("User C", 2000);
        result[3] = new Employee("User D", 3000);
        result[4] = new Employee("User E", 1200);
        result[5] = new Employee("User F", 3000);
        result[6] = new Employee("User H", 3000);
        result[7] = new Employee("User G", 3000);
        result[8] = new Employee("User I", 5000);
        result[9] = new Employee("User K", 3000);
        return result;
    }

    public static void print(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.printf("Name: %s, Salary: %d%n", employee.getName(), employee.getSalary());
        }
    }
}
