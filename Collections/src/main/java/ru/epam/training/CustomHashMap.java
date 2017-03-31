package ru.epam.training;

import java.util.*;

public class CustomHashMap<K, V> implements Map<K, V> {

    private static final int DEFAULT_CAPACITY = 16;

    private CustomEntry<K, V>[] buckets = new CustomEntry[DEFAULT_CAPACITY];

    private int size = 0;

    @Override
    public int size() {

        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        Objects.requireNonNull(key);
        return keyEntry((K) key) != null;
    }

    private CustomEntry<K, V> keyEntry(K key) {
        CustomEntry<K, V> bucket = buckets[hash(key)];
        return keyInBucket(bucket, key);
    }

    private CustomEntry<K, V> keyInBucket(CustomEntry<K, V> bucket, K key) {
        CustomEntry<K, V> currentEntry = bucket;
        while (currentEntry != null) {
            if (currentEntry.key.equals(key)) {
                return currentEntry;
            }
            currentEntry = currentEntry.next();
        }
        return null;
    }

    @Override
    public boolean containsValue(Object value) {
        return values().contains(value);
    }

    @Override
    public V get(Object key) {
        CustomEntry<K, V> keyEntry = keyEntry((K) key);
        return (keyEntry == null) ? null : keyEntry.getValue();
    }

    @Override
    public V put(K key, V value) {
        Objects.requireNonNull(key);
        int bucketNumber = hash(key);
        return putInBucket(bucketNumber, key, value);
    }

    private int hash(Object key) {
        return key.hashCode() % buckets.length;
    }

    private V putInBucket(int bucketNumber, K key, V value) {
        if (buckets[bucketNumber] == null) {
            buckets[bucketNumber] = new CustomEntry<>(key, value);
            size++;
            return null;
        }
        CustomEntry<K, V> currentEntry = buckets[bucketNumber];
        while (currentEntry.hasNext()) {
            if (currentEntry.key.equals(key)) {
                return currentEntry.setValue(value);
            }
            currentEntry = currentEntry.next();
        }
        if (currentEntry.key.equals(key)) {
            return currentEntry.setValue(value);
        }
        currentEntry.next = new CustomEntry<>(key, value);
        size++;
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        buckets = new CustomEntry[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        HashSet<K> keys = new HashSet<>();
        entrySet().forEach(x -> keys.add(x.getKey()));
        return keys;
    }

    @Override
    public Collection<V> values() {
        Set<Entry<K, V>> entries = entrySet();
        ArrayList<V> values = new ArrayList<>(entries.size());
        entries.forEach(x -> values.add(x.getValue()));
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entries = new HashSet<>();
        for (CustomEntry<K, V> bucket : buckets) {
            CustomEntry<K, V> entry = bucket;
            while (entry != null) {
                entries.add(entry);
                entry = entry.next();
            }
        }
        return entries;
    }

    private class CustomEntry<K, V> implements Iterator<CustomEntry<K, V>>, Map.Entry<K, V> {

        private final K key;
        private V value;
        private CustomEntry<K, V> next = null;

        CustomEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public CustomEntry<K, V> next() {
            return this.next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }
}
