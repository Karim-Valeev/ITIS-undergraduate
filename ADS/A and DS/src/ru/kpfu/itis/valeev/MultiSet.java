package ru.kpfu.itis.valeev;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MultiSet<T> {

    public T[] elements;
    public Pair[] dic;
    private int capacity;
    private int size;

    public MultiSet(T[] data){
        this.elements = (T[]) new Object[100];
        this.capacity = 100;

        for (int i=0; i<data.length; i++) {
            this.elements[i] = data[i];
        }

        dic = new Pair[100];
        for (int i = 0; i<data.length; i++) {

            dic[i] = new Pair<>(elements[i], 1);
            int counter = 1;

            for (int j = i+1; j<data.length; j++){
                if(elements[j].equals(elements[i])){
                    counter++;
                }
            }

            dic[i].value = counter;
        }

        this.size = data.length;
    }

    public void add(T element){
        this.elements[size] = element;

        for(int i = 0; i<this.size; i++){
            if(element.equals(dic[i].getKey())){
                dic[i].value = (int) dic[i].value + 1;
                return;
            }
        }

        dic[size] = new Pair<>(element, 1);
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
        int counter = 0;

        for(int i = 0; i<size; i++){
            if(element.equals(elements[i])){

                counter++;

                for(int j =0; j<size;j++){
                    elements[i] = elements[i+1];
                    dic[i]= dic[i+1];
                }

                size--;
                i--; // To remove all elements that are equal to given element
            }
        }

        if(counter == 0) throw new NoSuchElementException();
    }


    public boolean contains(MultiSet<T> otherSet){

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

    public void merge(MultiSet<T> otherSet) {

        for(int i = size; i < size + otherSet.size(); i++){
            elements[i] = otherSet.elements[i-size];
        }

        for(int j = 0; j<otherSet.size(); j++){
            for(int i = 0; i<size; i++){
                if (otherSet.elements[j].equals(dic[i].getKey())){
                    dic[i].setValue((int) dic[i].getValue()+1);
                    i = size; // instead of break;
                }
            }
        }

        size+=otherSet.size();
    }

    @Override
    public String toString() {
        return "MultiSet{" +
                "elements=" + Arrays.toString(Arrays.copyOf(elements, size)) +
                '}';
    }

    public static void main(String[] args) {

        MultiSet<Integer> set = new MultiSet<>(new Integer[]{1, 2, 3, 2, 1});

        System.out.println(set.has(3));

        set.add(6);
        set.add(7);
        set.add(0);
        System.out.println(set.toString());

        set.remove(0);
        System.out.println(set.toString());

        MultiSet<Integer> newSet = new MultiSet<>(new Integer[]{8,9,10});
        System.out.println(set.contains(newSet));

        if(!set.contains(newSet)){
            set.merge(newSet);
        }

        System.out.println("\n" + set.toString());

    }

}
