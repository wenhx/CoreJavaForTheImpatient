package ch04.e06;

public class E06 {
    public static void run() {
        DiscountedItem x = new DiscountedItem("Lamp", 100, 0.9);
        Item y = new Item("Lamp", 100);
        DiscountedItem z = new DiscountedItem("Lamp", 100, 0.8);
        System.out.println("x.equals(y) = " + x.equals(y));
        System.out.println("y.equals(z) = " + y.equals(z));
        System.out.println("x.equals(z) = " + x.equals(z));
    }
}
