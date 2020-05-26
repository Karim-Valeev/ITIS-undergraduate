package com.company;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Collection;

public class ModifableCollection<T> extends AbstractCollection<T> {

    private final static int DEFAULT_SIZE = 10;
    private T[] data;
    public int size;

    public ModifableCollection(){
        this.data = (T[]) new Objects[DEFAULT_SIZE];
        size = DEFAULT_SIZE;
    }

    public ModifableCollection(Collection<? extends T> collection){
        data = (T[]) new Object[collection.size()];
        size = 0;
        for(T element : collection){
            data[size] = element;
            size++;
        }
    }

    @Override
    public boolean add(T element){
        if(size >= data.length){
            T[] newData = (T[]) new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[size] = element;
        size++;
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorForEndlessArray<>(data);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModifableCollection)) return false;
        ModifableCollection<?> that = (ModifableCollection<?>) o;
        // If the elements in the collection are stored in an array and are strictly indexed.
        return size == that.size &&
                Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
}
