package ru.kpfu.itis.valeev;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Set<T> {

    private T[] elements;
    private int capacity;
    private int size;

    public Set(T[] data){
        this.elements = (T[]) new Object[1000];

        int k =0;
        for(T element : data){
            k++;
            for(int j=k;j<data.length;j++){
                if(element.equals(data[j])){
                    throw new IllegalArgumentException();
                }
            }
        }

        // Идея предложила
        System.arraycopy(data, 0, this.elements, 0, data.length);

        this.capacity = 1000;
        this.size = data.length;
    }

    public void add(T element){
        if(size==capacity){
            elements = Arrays.copyOf(elements,capacity*2);
            this.capacity *= 2;
        }
        
        for(int i =0; i < size;i++){
            if (elements[i].equals(element)){
                throw new IllegalArgumentException("Element is already in set.");
            }
        }

        this.elements[size] = element;
        size++;
    }

    public boolean has(T element){
        for(int i =0; i<size;i++){
            if (elements[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void remove(T element){
        for(int i = 0; i<size; i++){
            if(this.elements[i].equals(element)){
                for(int j=i; j<size-2;j++){
                    elements[j]=elements[j+1];
                }
                size--;
                return;
            }
        }
        throw new NoSuchElementException();
    }

    public void merge(Set<T> otherSet) {
        for (int i =0; i<otherSet.size();i++) {
            for (int j = 0; j<size; j++) {
                if(otherSet.elements[i].equals(elements[j])){
                    throw new IllegalArgumentException("Sets have same elements.");
                }
            }
        }

        for(int i = size; i < size + otherSet.size; i++){
            elements[i] = otherSet.elements[i-size];
        }
        size +=otherSet.size;

    }

    public boolean contains(Set<T> otherSet){
        boolean flag;
        for (T elementOfOtherSet : otherSet.elements) {
            flag = true;
            for (T element : this.elements) {
                if(elementOfOtherSet.equals(element)){
                    flag = false;
                    break;
                }
            }
            if(flag) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Set{" +
                "elements=" + Arrays.toString(Arrays.copyOf(elements, size)) +
                '}';
    }

    public static void main(String[] args) {

        Set<Integer> set = new Set<>(new Integer[]{1, 2, 3, 4, 5});

        System.out.println(set.has(3));

        set.add(6);
        set.add(7);
        set.add(0);
        System.out.println(set.toString());

        set.remove(0);
        System.out.println(set.toString());

        Set<Integer> newSet = new Set<>(new Integer[]{8,9,10});
        System.out.println(set.contains(newSet));

        if(!set.contains(newSet)){
            set.merge(newSet);
        }
        System.out.println(set.toString());



    }

}
