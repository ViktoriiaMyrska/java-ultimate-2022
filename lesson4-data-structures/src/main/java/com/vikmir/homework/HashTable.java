package com.vikmir.homework;

import java.util.Objects;

/**
 * A simple implementation of the Hash Table that allows storing a generic key-value pair. The table itself is based
 * on the array of {@link Node} objects.
 * <p>
 * An initial array capacity is 16.
 * <p>
 * Every time a number of elements is equal to the array size that tables gets resized
 * (it gets replaced with a new array that it twice bigger than before). E.g. resize operation will replace array
 * of size 16 with a new array of size 32. PLEASE NOTE that all elements should be reinserted to the new table to make
 * sure that they are still accessible  from the outside by the same key.
 *
 * @param <K> key type parameter
 * @param <V> value type parameter
 */
public class HashTable<K, V> {

    private int size = 0;
    private Node<K, V>[] buckets;

    @SuppressWarnings("unchecked")
    public HashTable() {
        buckets = new Node[16];
    }

    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Puts a new element to the table by its key. If there is an existing element by such key then it gets replaced
     * with a new one, and the old value is returned from the method. If there is no such key then it gets added and
     * null value is returned.
     *
     * @param key   element key
     * @param value element value
     * @return old value or null
     */
    public V put(K key, V value) {
        Objects.requireNonNull(key);
        int index = calculateIndex(key.hashCode());
        if (buckets[index] == null) {
            buckets[index] = new Node<>(key, value);
            size++;
            if (buckets.length == size) {
                resize(buckets.length * 2);
            }
        } else {
            Node<K, V> bucket = buckets[index];
            if (bucket.key.equals(key)) {
                V existingValue = bucket.value;
                bucket.value = value;
                return existingValue;
            } else {
                if (bucket.next == null) {
                    bucket.next = new Node<>(key, value);
                } else {
                    while (bucket.next != null) {
                        if (bucket.key.equals(key)) {
                            V existingValue = bucket.value;
                            bucket.value = value;
                            return existingValue;
                        } else {
                            bucket = bucket.next;
                        }
                    }
                }
            }
        }
        return value;
    }

    /**
     * Prints a content of the underlying table (array) according to the following format:
     * 0: key1:value1 -> key2:value2
     * 1:
     * 2: key3:value3
     * ...
     */
    public void printTable() {
        for (int i = 0; i < buckets.length; i++) {
            System.out.print(i + ": ");
            if (buckets[i] != null) {
                System.out.print(buckets[i].key + " " + buckets[i].value);
                if (buckets[i].next != null) {
                    Node<K, V> current = buckets[i];
                    while (current.next != null) {
                        System.out.print(" -> " + buckets[i].next.key + " " + buckets[i].next.value);
                        current = current.next;
                    }
                }
                System.out.println();
            } else {
                System.out.println();
            }
        }
    }

    private int calculateIndex(int hash) {
        return Math.abs(hash) % buckets.length;
    }

    private void resize(int newCapacity) {
        Node<K, V>[] currentBuckets = buckets;
        buckets = new Node[newCapacity];
        for (Node<K, V> bucket : currentBuckets) {
            if (bucket != null) {
                Node<K, V> current = bucket;
                put(current.key, current.value);
                while (current.next != null) {
                    current = current.next;
                    put(current.key, current.value);
                }
            }
        }
    }

}