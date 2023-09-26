package ch06.e03;

import java.util.ArrayList;
import java.util.Objects;

public class Table<K, V> {
    private ArrayList<Entry<K, V>> items = new ArrayList<>();

    public class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public V get(K key) {
        Objects.requireNonNull(key);
        for (Entry<K, V> item : items) {
            if (Objects.equals(key, item.key)) {
                return item.value;
            }
        }
        throw new RuntimeException(String.format("Key [%s] not found.", key + ""));
    }

    public void put(K key, V value) {
        Objects.requireNonNull(key);
        for (int i = 0; i < items.size(); i++) {
            if (Objects.equals(key, items.get(i).key)) {
                items.set(i, new Entry<>(key, value));
                return;
            }
        }
        items.add(new Entry<>(key, value));
    }

    public boolean remove(K key) {
        Objects.requireNonNull(key);
        for (int i = 0; i < items.size(); i++) {
            if (Objects.equals(key, items.get(i).key)) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }
}
