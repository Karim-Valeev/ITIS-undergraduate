package com.company;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Karim Valeev
 *
 * My EndlessArray class for homework.
 */
public class EndlessArray<T> implements Iterable<T> {

    /**
     * Method for testing our class
     * @param args
     */
    public static void main(String[] args) {
        EndlessArray<String> a = new EndlessArray<>(new String[] {"a", "b"});
        EndlessArray<String> b = new EndlessArray<>(new String[] {"b", "a"});
        a.add("adadasdfa");
        System.out.println(a.getSize());
        System.out.println(a.toString());
        a.remove(0);
        System.out.println(a.toString());
        System.out.println(a.get(100));
        System.out.println(a.equals(b)); // >>> false

    }

    /**
     * Needed fields
     */
    private final static int DEFAULT_CAPACITY = 10;
    private T[] list;
    private int size;

    public EndlessArray() {
        this(DEFAULT_CAPACITY);
    }
    public EndlessArray(int capacity) {
        list = (T[]) new Object[capacity];
        size = 0;
    }
    public EndlessArray(T[] list) {         //DONE
        list = Arrays.copyOf(list, list.length);
        size = list.length;
    }

    /**
     *
     * @param element
     */
    public void add(T element) {             //DONE
        if(size == list.length) {
            extendsArray();
        }
        list[size] = element;
        size++;
    }

    /**
     *
     * @param element, toIndex
     * @param toIndex
     * @throws ArrayIndexOutOfBoundsException
     */
    public void add(T element, int toIndex) {
        try {
            if (size == list.length) {
                extendsArray();
            }
            for (int i = toIndex; i < size; i++) {
                list[i] = list[i + 1];
            }
            list[toIndex] = element;
            size++;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds.");
        }
    }

    /**
     *
     * @param index
     * @throws ArrayIndexOutOfBoundsException
     */
    public void remove(int index) {                  //DONE
        try {
            for (int i = index; i < list.length - 1; i++) {
                list[i] = list[i + 1];
            }
            size--;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds.");
        }
    }

    /**
     *
     * @return
     */
    public int getSize() {           //DONE
        return size;
    }

    /**
     *
     * @param str
     * @return
     */
    public int indexOf(String str) {
        int y = -1;
        for (int i = 0; i< size; i++) {
            if (list[i].equals(str)){
                y = i;
            }
        }
        return y;
    }

    /**
     *
     * @param index
     * @return array's element
     * @throws ArrayIndexOutOfBoundsException
     */
    public T get(int index) {     //DONE   //EXCEPTION ADDED
        if (index<0 || index> size) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return list[index];
        }
    }

    private void extendsArray() {                                           //DONE
        list = Arrays.copyOf(list, (int)(list.length*1.5));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EndlessArray)) return false;

        EndlessArray that = (EndlessArray) o;

        if (size != that.size) return false;
        return Arrays.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(list);
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }

    /**
     *
     * @return
     */
    public T[] getList() {
        return Arrays.copyOf(list, size);
    }

    /**
     *
     * @param a, b
     * @throws ArrayIndexOutOfBoundsException
     */
	public void swap(int a, int b){
		try {
		    T buff = list[a];
            list[a] = list[b];
            list[b] = buff;
        } catch (ArrayIndexOutOfBoundsException e){
		    throw new ArrayIndexOutOfBoundsException();
        }
	}


    @Override
    public Iterator<T> iterator() {
        return new IteratorForEndlessArray(list);
    }
}
