package org.example.homeWorks.hw9.cache;

import java.util.Map;
import java.util.WeakHashMap;

public class MyCache<K, V> {

    private final Map<K, V> cache = new WeakHashMap<>();

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public V get(K key) {
        return cache.get(key);
    }

    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }

    public int size() {
        return cache.size();
    }
}