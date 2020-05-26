package com.company;

import java.util.Iterator;

public class IteratorForEndlessArray<T> implements Iterator<T> {
    public T[] data;
    private int cursor;

    public IteratorForEndlessArray(T[] data){
        this.cursor = 0;
        this.data = data;
    }


    @Override
    public boolean hasNext() {
        return cursor < data.length;
    }

    @Override
    public T next() {
        try{
            cursor++;
            int n = cursor - 1;
            return data[n];
        } catch (ArrayIndexOutOfBoundsException ex){
            throw new java.util.NoSuchElementException();
        }
    }

    @Override
    public void remove() {
        for(int i = cursor; i < data.length - 1; i++){
            data[i] = data[i+1];
        }
        cursor--;
    }
}
