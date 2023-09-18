package ch04.e09;

import java.util.Objects;

public class Node {
    private Item item;
    public class Item {
        private Node parent;
        private String name;

        public Item(Node parent, String name) {
            this.parent = parent;
            this.name = name;
        }

        public Node getParent() {
            return parent;
        }

        public String getName() {
            return name;
        }
    }

    public void add(String name) {
        Objects.requireNonNull(name);
        item = new Item(this, name);
    }
}
