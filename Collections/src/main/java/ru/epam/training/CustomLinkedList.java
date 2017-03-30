package ru.epam.training;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CustomLinkedList<T> implements List<T> {

    private Node<T> head = new Node<>(null);
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return !head.hasNext();
    }

    @Override
    public boolean contains(Object o) {
        Node<T> node = head;
        while (node.hasNext()) {
            node = node.next;
            if (node.value == null) {
                if (o == null) {
                    return true;
                }
            } else if (node.value.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        Node<T> iterator = head;
        while (iterator.hasNext()) {
            iterator = iterator.next;
        }
        iterator.next = new Node<>(t);
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> current = head.next;
        Node<T> prev = head;
        while (current != null) {
            if (o.equals(current.value)) {
                prev.next = current.next;
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T cur : c) {
            if (!this.add(cur)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        T[] array = (T[]) c.toArray();
        for (int i = array.length - 1; i >=0; i--) {
            this.add(index, array[i]);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        head = new Node<>(null);
        size = 0;
    }

    @Override
    public T get(int index) {
        return getNodeByIndex(index).value;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {
        Node<T> current = getNodeByIndex(index - 1);
        size++;
        Node<T> nodeToAdd = new Node<>(element);

        nodeToAdd.next = current.next;
        current.next = nodeToAdd;
    }

    @Override
    public T remove(int index) {
        Node<T> current = getNodeByIndex(index - 1);
        Node<T> next = getNodeByIndex(index);
        size--;
        T value = next.value;
        current.next = current.next.next;
        return value;
    }

    @Override
    public int indexOf(Object o) {
        Node<T> current = head.next;
        int currentIndex = 0;
        while (current != null) {
            if (o.equals(current.value)) {
                return currentIndex;
            }
            current = current.next;
            currentIndex++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {

        Node<T> current = getNodeByIndex(fromIndex);
        Node<T> end = getNodeByIndex(toIndex);

        CustomLinkedList<T> result = new CustomLinkedList<>();
        while (current != end.next) {
            result.add(current.value);
            current = current.next;
        }
        return result;
    }

    private Node<T> getNodeByIndex(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private class Node<T> {

        private Node<T> next;
        private T value;

        public Node(T value) {
            this.value = value;
        }

        public boolean hasNext() {
            return next != null;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomLinkedList)) return false;

        CustomLinkedList<?> that = (CustomLinkedList<?>) o;

        if (size != that.size) return false;

        Node<T> currentThis = head.next;
        Node<T> currentO = ((CustomLinkedList) o).head.next;
        while (currentThis != null) {
            if (!currentO.value.equals(currentThis.value)) {
                return false;
            }
            currentThis = currentThis.next;
            currentO = currentO.next;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = head.hashCode();
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head.next;
        while (current != null) {
            sb.append(current.value);
            sb.append("\n");
            current = current.next;
        }
        return sb.toString();
    }
}
