package ru.epam.training;

import java.util.*;

public class CustomArrayList<T> implements List<T> {

    public static final int CAPACITY = 10;

    private Object[] data = new Object[CAPACITY];
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
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (data[i] == null) {
                if (o == null) {
                    return true;
                }
            } else if (data[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int currentPosition = 0;

            @Override
            public boolean hasNext() {
                return currentPosition<size;
            }

            @Override
            public T next() {
                return (T) data[currentPosition++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        assureCapacity();
        data[size++] = t;
        return true;
    }


    @Override
    public boolean remove(Object o) {

        int index = indexOf(o);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
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
        for (int i = array.length - 1; i >= 0; i--) {
            this.add(index, array[i]);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            remove(o);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (Object o : this) {
            if (!c.contains(o)) {
                remove(o);
            }
        }
        return true;
    }

    @Override
    public void clear() {
        data = new Object[CAPACITY];
        size = 0;
    }

    @Override
    public T get(int index) {
        checkIndexOutOfBound(index);
        return (T) data[index];
    }

    private void checkIndexOutOfBound(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {
        checkIndexOutOfBound(index);
        assureCapacity();
        int length = data.length - index;
        System.arraycopy(data, index, data, index + 1, length - 1);
        data[index] = element;
        size++;
    }


    @Override
    public T remove(int index) {
        checkIndexOutOfBound(index);
        int length = data.length - index;
        T value = (T) data[index];
        System.arraycopy(data, index + 1, data, index, length - 1);
        size--;
        return value;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(data[i])) {
                return i;
            }
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomArrayList)) return false;

        CustomArrayList<?> that = (CustomArrayList<?>) o;

        if (size != that.size) return false;
        for (int i = 0; i < this.size; i++) {
            if (!this.data[i].equals(that.data[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(data);
        result = 31 * result + size;
        return result;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        checkIndexOutOfBound(fromIndex);
        checkIndexOutOfBound(toIndex);
        CustomArrayList<T> result = new CustomArrayList<>();
        result.data = Arrays.copyOfRange(this.data, fromIndex, toIndex + 1);
        result.size = result.data.length;
        return result;
    }

    private void assureCapacity() {
        if (size == data.length) {
            int newLength = (data.length * 3) / 2 + 1;
            data = Arrays.copyOf(data, newLength);
        }
    }
}
