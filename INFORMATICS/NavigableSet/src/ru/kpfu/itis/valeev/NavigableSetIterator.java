package ru.kpfu.itis.valeev;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class NavigableSetIterator<T> implements Iterator<T> {
    private ArrayList<T> data = new ArrayList<>();
    private int cursor;

    public NavigableSetIterator(ArrayList<T> list) {
        this.data = list;
        cursor = 0;
    }

    @Override
    public boolean hasNext() {
        return data.size() > cursor;
    }

    @Override
    public T next() {
        if (hasNext()){
            return data.get(cursor++);
        }
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        if(hasNext()) data.remove(cursor);
    }
}
