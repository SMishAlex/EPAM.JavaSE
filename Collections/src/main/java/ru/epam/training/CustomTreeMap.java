package ru.epam.training;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class CustomTreeMap<K extends Comparable<K>, V> implements Map<K, V> {

    private Node<K, V> root;
    private V previousValue;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    private Node<K, V> next(Node<K, V> currentNode, K key) {
        int compare = currentNode.key.compareTo(key);
        if (compare < 0) {
            return currentNode.right;
        } else if (compare > 0) {
            return currentNode.left;
        } else
            return currentNode;
    }

    @Override

    public boolean containsKey(Object key) {
        Objects.requireNonNull(key);
        if (root == null) return false;
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
            Node<K, V> previousNode = currentNode;
            currentNode = next(currentNode, key);
            if (previousNode==currentNode){
                return currentNode;
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        Objects.requireNonNull(key);
        root = put(root, key, value);
        return previousValue;
    }

    private Node<K, V> put(Node<K, V> node, K key, V value) {
        if (node == null) {
            size++;
            return new Node<>(key, value);
        }
        if (node.key.equals(key)) {
            previousValue = node.value;
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
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
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
