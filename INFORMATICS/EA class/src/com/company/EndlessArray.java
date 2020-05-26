package com.company;

import java.util.Arrays;

/**
 * @author Karim Valeev
 *
 * My EndlessArray class for homework.
 */
public class EndlessArray<T> {

    /**
     * Method for testing our class
     * @param args
     */
    public static void main(String[] args) {
        EndlessArray<String> a = new EndlessArray<>(new String[] {"a", "b"});
        EndlessArray<String> b = new EndlessArray<>(new String[] {"b", "a"});
        a.add("adadasdfa");
        System.out.println(a.getActualSize());
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
    private int actualSize;

    public EndlessArray() {
        this(DEFAULT_CAPACITY);
    }
    public EndlessArray(int capacity) {
        list = (T[]) new Object[capacity];
        actualSize = 0;
    }
    public EndlessArray(T[] list) {         //DONE
        list = Arrays.copyOf(list, list.length);
        actualSize = list.length;
    }

    /**
     *
     * @param ?
     */
    public void add(T element) {             //DONE
        if(actualSize == list.length) {
            extendsArray();
        }
        list[actualSize] = element;
        actualSize++;
    }

    /**
     *
     * @param ?
     * @param toIndex
     * @throws ArrayIndexOutOfBoundsException
     */
    public void add(T element, int toIndex) {
        //ToDo: do smthng
        //DONE      //EXCEPTION ADDED
            if (actualSize == list.length) {
                extendsArray();
            }
            for (int i = toIndex; i < actualSize; i++) {
                list[i] = list[i + 1];
            }
            list[toIndex] = element;
            actualSize++;
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
            actualSize--;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     *
     * @return
     */
    public int getSize() {           //DONE
        return actualSize;
    }

    /**
     *
     * @param str
     * @return
     */
    public int indexOf(String str) {      //DONE
        int y = -1;
        for (int i =0; i< actualSize; i++) {
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
        if (index<0 || index>actualSize) {
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

        if (actualSize != that.actualSize) return false;
        return Arrays.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(list);
        result = 31 * result + actualSize;
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list,actualSize));
    }

    /**
     *
     * @return
     */
    public T[] getStrList() {
        return Arrays.copyOf(list, actualSize);
    }

   
}
