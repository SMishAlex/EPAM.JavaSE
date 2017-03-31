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
        // TODO: 31.03.17
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

    //region removing
    @Override
    public V remove(Object key) {
        root = delete(root, (K) key);
        return null;
    }

    private Node<K, V> deleteMin(Node<K, V> x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    private Node<K, V> delete(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo((K) x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            size--;
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;

            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }

    private Node<K, V> min(Node<K, V> tree) {
        while (tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }
    //endregion

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        // TODO: 31.03.17
    }

    @Override
    public void clear() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public Set<K> keySet() {
        // TODO: 31.03.17
        return null;
    }

    @Override
    public Collection<V> values() {
        // TODO: 31.03.17
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        // TODO: 31.03.17
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