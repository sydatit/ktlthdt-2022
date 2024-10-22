package prepare.interview.collection.impl;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_ELEMENT_SIZE = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_ELEMENT_SIZE];
    }

    public void add(E element) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = element;
    }

    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elements[index];
    }

}
