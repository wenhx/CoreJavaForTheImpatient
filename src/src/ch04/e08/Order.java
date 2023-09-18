package ch04.e08;

import java.util.ArrayList;

public class Order {
    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(int id) {
        items.add(new Item(id));
    }

    public class Item {
        private int id;

        public Item(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    public Item getItem(int itemId) {
        for (Item item : items) {
            if (item.id == itemId)
                return item;
        }
        return null;
    }
}
