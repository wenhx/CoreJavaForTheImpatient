package ch07.e13;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache extends LinkedHashMap {
    private int maxEntries;

    public Cache(int maxEntries) {
        super(maxEntries);
        this.maxEntries = maxEntries;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > maxEntries;
    }
}
