package ru.kpfu.itis.valeev;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyQueue {

    //FIFO = first-in first-out
    // enqueue = add()
    // dequeue = remove()

    private int[] elements;
    private int capacity;
    private int size;

    public MyQueue() {
        elements = new int[100];
        capacity = 100;
        size = 0;
    }

    public boolean enqueue(int a){
        if(size==capacity){
            elements = Arrays.copyOf(elements,capacity*2);
            this.capacity *= 2;
        }

        elements[size] = a;
        size++;
        return  true;
    }

    public int dequeue(){
        if (size == 0){
            throw  new NoSuchElementException("Queue is empty.");
        }

        int buff = elements[0];

        for(int i = 0; i<size-2;i++){
            elements[i] = elements[i+1];
        }

        size--;
        return buff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyQueue myQueue = (MyQueue) o;
        return size == myQueue.size &&
                Arrays.equals(elements, myQueue.elements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "elements=" + Arrays.toString(Arrays.copyOf(elements, size)) +
                '}';
    }

    public static void main(String[] args) {

        MyQueue mq = new MyQueue();
        mq.enqueue(1);
        mq.enqueue(2);
        mq.enqueue(3);
        mq.enqueue(4);
        mq.enqueue(5);
        System.out.println(mq.toString());
        mq.dequeue();
        mq.dequeue();
        System.out.println(mq.toString());

    }

}
