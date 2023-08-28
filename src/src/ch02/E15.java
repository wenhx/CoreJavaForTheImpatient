package ch02;

public class E15 {
    public static void run() {
        Invoice invoice = new Invoice();
        invoice.add(new Invoice.Item("Cheese Cake", 1, 10));
        invoice.add(new Invoice.Item("Ice Cream", 3, 2));
        invoice.add(new Invoice.Item("Black Chocolate", 5, 5));
        invoice.add(new Invoice.Item("Hamburger", 2, 10));
        invoice.print();
    }
}
