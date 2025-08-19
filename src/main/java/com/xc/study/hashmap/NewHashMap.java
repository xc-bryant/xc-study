package com.xc.study.hashmap;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * @author bryant
 * @date 2025/8/19
 **/
public class NewHashMap<K, V> implements NewMap<K, V> {

    Entry<K, V>[] entry = null;

    public NewHashMap() {
        entry = new Entry[16];
    }

    int size = 0;

    @Override
    public V put(K key, V value) {
        int hashCode = key.hashCode();
        int index = hash(hashCode);
        Entry<K, V> kvEntry = entry[index];
        if (kvEntry == null) {
            entry[index] = new Entry<>(hashCode, key, value, null);
        } else {
            entry[index] = new Entry<>(hashCode, key, value, kvEntry);
        }
        size++;
        return value;
    }


    @Override
    public V get(K key) {
        int hashCode = key.hashCode();
        int index = hash(hashCode);
        Entry<K, V> kvEntry = entry[index];
        if (kvEntry == null) {
            return null;
        } else {
            while (!kvEntry.key.equals(key)) {
                kvEntry = kvEntry.next;
            }
            return kvEntry.value;
        }
    }

    @Override
    public void forEach(BiConsumer<K, V> consumer) {
        if (consumer == null) {
            throw new NullPointerException();
        }
        Entry[] tab;
        if (size > 0 && (tab = entry) != null) {
            for (int i = 0; i < tab.length; i++) {
                for (Entry<K, V> e = tab[i]; e != null; e = e.next) {
                    consumer.accept(e.key, e.value);
                }
            }
        }
    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        if (function == null) {
            throw new NullPointerException();
        }
        Entry[] tab;
        if (size > 0 && (tab = entry) != null) {
            for (int i = 0; i < tab.length; i++) {
                for (Entry<K, V> e = tab[i]; e != null; e = e.next) {
                    e.value = function.apply(e.key, e.value);
                }
            }
        }
    }

    @Override
    public void replaceAllKey(BiFunction<? super K, ? super V, ? extends K> function) {
        if (function == null) {
            throw new NullPointerException();
        }
        Entry[] tab;
        if (size > 0 && (tab = entry) != null) {
            for (int i = 0; i < tab.length; i++) {
                for (Entry<K, V> e = tab[i]; e != null; e = e.next) {
                    e.key = function.apply(e.key, e.value);
                }
            }
        }
    }

    private int hash(int hash) {
        return hash % 10;
    }

    @Override
    public int size() {
        return size;
    }

    static class Entry<K, V> implements NewMap.Entry<K, V> {
        int index;
        K key;
        V value;
        Entry<K, V> next;

        public Entry(int index, K key, V value, Entry<K,V> next) {
            this.index = index;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }
}
