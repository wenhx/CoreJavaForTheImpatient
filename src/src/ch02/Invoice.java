package ch02;

import java.util.ArrayList;

public class Invoice {
    public static class Item {
        String description;
        int quantity;
        double unitPrice;

        public Item(String description, int quantity, double unitPrice) {
            this.description = description;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }

        double price() {
            return quantity * unitPrice;
        }
    }

    private ArrayList<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public void print() {
        System.out.println("Item                quantity  (unit price)");
        for (Item item: items) {
            System.out.printf("%-15s %10d %10g%n", item.description, item.quantity, item.unitPrice);
        }
    }
}
