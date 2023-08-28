package ch02;

public class E09 {
    public static void run() {
        Car car = new Car(1);
        car.addGallons(100);
        car.drive(80);
        car.addGallons(100);
        car.drive(120);
        System.out.printf("The distance: %g miles, The fuel level: %g", car.getMiles(), car.getGallons());
    }
}
