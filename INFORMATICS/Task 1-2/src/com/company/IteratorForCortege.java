package com.company;

import java.util.Iterator;

public class IteratorForCortege<T> implements Iterator<T> {
    public T[] data;
    private int cursor;

    public IteratorForCortege(T[] data) {
        this.cursor = 0;
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return cursor < data.length;
    }

    @Override
    public T next() {
        try {
            cursor++;
            int n = cursor - 1;
            return data[n];
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new java.util.NoSuchElementException();
        }
    }


}
