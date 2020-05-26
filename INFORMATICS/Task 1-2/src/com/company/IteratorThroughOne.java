package com.company;

import java.util.Iterator;

public class IteratorThroughOne<T> implements Iterator<T> {

    public T[] data;
    private int cursor;

    public IteratorThroughOne(T[] data){
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
            while(data[cursor] == null) {
                cursor += 2;
            }

            cursor += 2;
            int n = cursor - 2;
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
