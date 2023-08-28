package ch02;

public class Car {
    private double fuelEfficiency = 1;
    private double miles = 0;
    private double gallons = 0;

    public double getFuelEfficiency() {
        return fuelEfficiency;
    }

    public double getMiles() {
        return miles;
    }

    public double getGallons() {
        return gallons;
    }

    public Car(double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    public void addGallons(double gallons) {
        this.gallons += gallons;
    }

    public void drive(double miles) {
        double gallons = miles / fuelEfficiency;
        if (gallons > this.gallons)
            throw new IllegalArgumentException("Fuel not enough.");

        this.miles += miles;
        this.gallons -= gallons;
    }
}
