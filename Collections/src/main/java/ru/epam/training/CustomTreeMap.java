package ru.epam.training;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class CustomTreeMap<K extends Comparable<K>, V> implements Map<K, V> {

    private Node<K, V> root;
    private V previosValue;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean containsKey(Object key) {
        Objects.requireNonNull(key);
        if (root == null) return false;
        root.key.compareTo((K) key);
        return find(root, (K) key) != null;
    }

    @Override
    public boolean containsValue(Object value) {
        if (root == null) return false;
        if (root.value == null) {
            return value == null;
        } else {
            return root.value.equals(value);
        }
    }

    @Override
    public V get(Object key) {
        Node<K, V> node = nodeWithKey((K) key);
        return (node == null) ?
                null :
                node.value;
    }

    private Node<K, V> nodeWithKey(K key) {
        Node<K, V> currentNode = root;
        while (currentNode != null) {
            int compere = currentNode.key.compareTo(key);
            if (compere < 0) {
                currentNode = currentNode.right;
            } else if (compere > 0) {
                currentNode = currentNode.left;
            } else {
                return currentNode;
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        Objects.requireNonNull(key);
        root = put(root, key, value);
        return previosValue;
    }

    private Node<K, V> put(Node<K, V> node, K key, V value) {
        if (node == null) {
            size++;
            return new Node<>(key, value);
        }
        if (node.key.equals(key)) {
            previosValue = node.value;
            node.value = value;
        } else if (node.key.compareTo(key) > 0) {
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }
        return node;
    }

    private Node<K, V> find(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        if (node.key.equals(key)) {
            return node;
        } else if (node.key.compareTo(key) > 0) {
            return find(node.left, key);
        } else {
            return find(node.right, key);
        }
    }

    @Override
    public V remove(Object key) {
        Node<K, V> parent = parentOf((K) key);
        return parent.value;
    }

    private Node<K, V> parentOf(K key) {
        Node<K, V> currentNode = root;
        Node<K, V> previousNode = null;

        while (currentNode != null) {
            int compere = currentNode.key.compareTo(key);
            if (compere == 0) {
                return previousNode;
            }
            previousNode = currentNode;
            if (compere < 0) {
                currentNode = currentNode.right;
            } else if (compere > 0) {
                currentNode = currentNode.left;
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    private class Node<K extends Comparable<K>, V> {
        private final K key;
        private V value;
        private Node<K, V> left;
        private Node<K, V> right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

}
