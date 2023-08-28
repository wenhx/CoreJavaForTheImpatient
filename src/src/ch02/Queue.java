package ch02;

public class Queue {
    private Node first;
    private Node last;

    public void add(String str) {
        Node node = new Node(str);
        if (first == null) {
            first = node;
        } else {
            last.next = node;
            node.previous = last;
        }
        last = node;
    }

    public String remove() {
        if (first == null)
            return null;

        String value = first.value;
        first = first.next;
        return value;
    }

    public Iterator iterator() {
        return new Iterator();
    }

    public static class Node {
        private Node previous;
        private Node next;
        private String value;

        public Node(String value) {
            this.value = value;
        }

        public Node getPrevious() {
            return previous;
        }

        public Node getNext() {
            return next;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public class Iterator {
        private Node current;

        public Iterator() {
            current = first;
        }

        public String next() {
            if (current == null)
                return null;

            String value = current.value;
            current = current.next;
            return value;
        }

        public boolean hasNext() {
            if (current != null)
                return true;
            return false;
        }
    }
}