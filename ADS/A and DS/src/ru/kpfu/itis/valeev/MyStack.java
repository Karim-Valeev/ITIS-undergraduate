package ru.kpfu.itis.valeev;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;

public class MyStack{
    // доделать очередь и тесты
    // LIFO = last-in first-out

    private int[] elements;
    private int capacity;
    private int size;

    public MyStack() {
        elements = new int[100];
        capacity = 100;
        size = 0;
    }

    public int push(int a){
        if(size==capacity){
            elements = Arrays.copyOf(elements,capacity*2);
            this.capacity *= 2;
        }

        elements[size] = a;
        size++;
        return a;
    }

    public int pop(){
        if(size == 0){
            throw new EmptyStackException();
        }

        int buff = elements[size-1];
        elements[size-1] = 0;
        size--;
        return buff;

    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "elements=" + Arrays.toString(Arrays.copyOf(elements, size)) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyStack myStack = (MyStack) o;
        return size == myStack.size &&
                Arrays.equals(elements, myStack.elements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }

    public static void main(String[] args) {

        MyStack ms = new MyStack();
        ms.push(1);
        ms.push(2);
        ms.push(3);
        ms.push(4);
        System.out.println(ms.toString());
        ms.pop();
        System.out.println(ms.toString());

    }

}
