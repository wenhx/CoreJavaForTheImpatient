package ch03.e01;

public class Employee implements Measurable {
    private double measure;

    public Employee(double measure) {
        this.measure = measure;
    }

    @Override
    public double getMeasure() {
        return this.measure;
    }
}
