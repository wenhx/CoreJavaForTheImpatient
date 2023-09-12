package ch03.e02;

public class Employee extends ch03.e01.Employee {
    private String name;

    public String getName() {
        return name;
    }

    public Employee(String name, double measure) {
        super(measure);
        this.name = name;
    }
}
