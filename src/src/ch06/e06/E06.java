package ch06.e06;

import java.util.ArrayList;
import java.util.Objects;

public class E06 {
    public static void run() {
        runSolution1();
        System.out.println("-----------------------------------------------------");
        runSolution2();
    }

    private static void runSolution2() {
        ArrayList<Employee> employees = getEmployees();
        ArrayList<Manager> managers = getManagers();
        for (Object employee : append2(employees, managers)) {
            System.out.println(((Employee)employee).getName());
        }
    }

    private static void runSolution1() {
        ArrayList<Employee> employees = getEmployees();
        ArrayList<Manager> managers = getManagers();
        for (Employee employee : append1(employees, managers)) {
            System.out.println(employee.getName());
        }
    }

    private static ArrayList<Manager> getManagers() {
        ArrayList<Manager> managers = new ArrayList<>();
        managers.add(new Manager("Manager 1"));
        managers.add(new Manager("Manager 2"));
        return managers;
    }

    private static ArrayList<Employee> getEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Employee 1"));
        employees.add(new Employee("Employee 2"));
        return employees;
    }

    public static <E> ArrayList<E> append1(ArrayList<E> list, ArrayList<? extends E> other) {
        Objects.requireNonNull(list);
        Objects.requireNonNull(other);
        for (E e : other) {
            list.add(e);
        }
        return list;
    }

    public static <E> ArrayList<? super E> append2(ArrayList<? super E> list, ArrayList<E> other) {
        Objects.requireNonNull(list);
        Objects.requireNonNull(other);
        for (E e : other) {
            list.add(e);
        }
        return list;
    }
}
