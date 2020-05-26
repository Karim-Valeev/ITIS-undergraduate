package com.company;

import java.util.Arrays;
import java.util.Iterator;

public class IteratorBeginnigAndTheEnd<T> implements Iterator<T> {
    public T[] data;
    public static int[] buff;
    private int cursor;
    int counter;


    public IteratorBeginnigAndTheEnd(T[] data){
        this.cursor = -1;
        this.data = data;
        int n = data.length;
        buff  = new int[n];
        int c1=0, c2 =0;
        for (int i = 0; i <  n; i++) {
            if (i%2 == 0) {
                buff[i] = c1;
                c1++;
            } else {
                buff[i] = n - 1 - c2;
                c2++;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return (counter<data.length);
    }

    @Override
    public T next() {
        counter++;
        cursor++;
        return data[buff[cursor]];

    }

    @Override
    public void remove() {
        data[cursor] = null;
    }


}
