package com.company;

import java.util.AbstractCollection;
import java.util.Objects;
import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

public class Cortege<T> extends AbstractCollection<T> {

    private final static int DEFAULT_SIZE = 10;
    private T[] data;
    public int size;

    public Cortege(){
        this.data = (T[]) new Objects[DEFAULT_SIZE];
        size = DEFAULT_SIZE;
    }

    public Cortege(Collection<? extends T> c){
        data = (T[]) new Object[c.size()];
        size = 0;
        for(T element : c){
            data[size] = element;
            size++;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorForCortege<>(data);
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i = 0; i<5; i++){
            a.add(i,i+1);
            System.out.println(a.get(i));
        }
        System.out.println();
        Collection<Integer> c = new Cortege<>(a);
        Iterator<Integer> it = c.iterator();
        System.out.println(it.next());
        System.out.println(it.next());

        System.out.println();
        for(int el : c){
            System.out.println(el);
        }
    }
}
