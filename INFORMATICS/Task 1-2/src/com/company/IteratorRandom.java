package com.company;

import java.util.Iterator;

public class IteratorRandom<T> implements Iterator<T> {

    public T[] data;
    private int cursor;

    public IteratorRandom(T[] data){
        this.data = data;
        this.cursor = Math.abs((int) ((data.length-1) * Math.random()));

    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public T next() {
        cursor = Math.abs((int) (data.length * Math.random()-1));
        return data[cursor];
    }

    @Override
    public void remove() {
        data[cursor] = null;
    }
}
