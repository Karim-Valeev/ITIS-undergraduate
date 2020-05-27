package ru.kpfu.itis.valeev;

import java.util.NoSuchElementException;
import java.util.Objects;

public class MyLinkedList<T> {

    private class Node<T>{
        public T value;
        public Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public Node(Node<T> n){
            this.value = n.getValue();
            this.next = n.getReference();
        }

        // equals
        public T getValue(){
            return value;
        }
        public void setReference(Node<T> next){
            this.next = next;
        }
        public Node<T> getReference(){
            return this.next;
        }
    }

    // Fields
    private Node<T> head, tail;
    private int size;

    // Constructors
    public MyLinkedList(){
        this.size=0;
    }
    public MyLinkedList(T headElement){
        this.head = new Node<>(headElement, null);
        this.tail = head;
    }
    public MyLinkedList(MyLinkedList<T> data){
        this.head = data.head;
        this.tail = data.tail;
        this.size = data.size;
    }

    //Methods
    public T getFirst(){
        if(head != null){
            return head.getValue();
        }
        return null;
    }

    public void addLast(T element){
        Node<T> buff = new Node<>(element, null);
        tail.setReference(buff);
        tail = buff;
        size++;
    }

    public void addFirst(T element){
        if(size==0){
            this.head = new Node<>(element, null);
            this.tail = head;
        }else if(size == 1){
            Node<T> buff = new Node<>(head);
            this.head = new Node<>(element, null);
            this.head.setReference(buff);
            this.tail = buff;
        }else {
            Node<T> buff = new Node<>(head);
            head = new Node<>(element, null);
            head.setReference(buff);
        }
        size++;
    }

    public int indexOf(T element){
        int i = 0;
        Node<T> buff = head;
        while(!element.equals( buff.getValue())){
            i++;
            buff = buff.getReference();

            if(i==size) return -1;
        }
        return i;
    }

    public int size(){
        int i=0;
        Node<T> buff = head;
        while(!(buff.getReference() == null)){
            i++;
            buff = buff.getReference();
        }
        this.size = i+1;
        return size;
    }

    public void addAfter(int index, T element){
        if(index<0){
            throw new IndexOutOfBoundsException("Index must be natural.");
        }

        if(index == size - 1){
            addLast(element);
        }

        Node<T> buff = head;
        int i =0;
        while (i != index){
            i++;
            buff = buff.getReference();
            if (buff == null){
                throw new IndexOutOfBoundsException("LinkedList's size is only " + i);
            }
        }
        Node<T> newElement = new Node<>(element, buff.getReference());
        buff.setReference(newElement);
        size++;
    }

    public void merge(MyLinkedList<T> data){
        Node<T> buff = tail;
        buff.setReference(data.head);
        this.tail = data.tail;
        size = this.size() + data.size();
    }

    public void removeByIndex(int index){
        if(index<0){
            throw new IndexOutOfBoundsException("Index must be natural.");
        } else if(index>=size()){
            throw new IndexOutOfBoundsException("LinkedList's size is only " + size);
        }

        if (size == 1){
            head = null;
            return;
        }

        if(index == 0){
            head = head.getReference();

        }else if(index == size-1){
            Node<T> buff = head;
            for(int i = 0; i< size-2;){
                buff = buff.getReference();
            }
            buff.setReference(null);
            tail = buff;

        } else {
            Node<T> buff = head;
            int i = 0;
            while (i + 1 != index) {
                i++;
                buff = buff.getReference();
            }
            buff.setReference(buff.getReference().getReference());
            size--;
        }
    }

    public void removeByValue(T element){
        int i = this.indexOf(element);
        if(i == -1) throw new NoSuchElementException();
        this.removeByIndex(i);
    }

    public T get(int index){
        if(index<0){
            throw new IndexOutOfBoundsException("Index must be natural.");
        } else if(index>=size){
            throw new IndexOutOfBoundsException("LinkedList's size is only " + size);
        }

        Node<T> buff = head;
        int i = 0;
        while (i != index){
            i++;
            buff = buff.getReference();
        }
        return buff.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyLinkedList)) return false;
        MyLinkedList<T> that = (MyLinkedList<T>) o;
        if(this.size() != that.size()) return false;

        Node<T> buff1 = this.head;
        Node<T> buff2 = that.head;
        for (int i =0; i<that.size();i++) {
            if (buff1.getValue() != buff2.getValue()) return false;
            buff1 = buff1.getReference();
            buff2 = buff2.getReference();
        }

        return true;

    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail, size);
    }

    @Override
    public String toString() {
        StringBuilder str;
        Node<T> buff = head;
        str = new StringBuilder("" + buff.getValue());
        for(int i = 1; i < size(); i++){
            buff = buff.getReference();
            str.append(" ").append(buff.getValue());
        }

        return "MyLinkedList{ " +
                str +
                " }";
    }

    //Testing
    public static void main(String[] args) {
        MyLinkedList<Integer> a = new MyLinkedList<>();

        a.addFirst(51984);
        a.addAfter(0,1);
        a.addLast(2);
        a.addLast(3);
        System.out.println("head value is: "+ a.head.value + "\n" + "tail value is: " + a.tail.getValue() + "\n");
        a.removeByIndex(1);
        System.out.println(a.get(0));
        System.out.println("LinkedList size is: " + a.size());
        System.out.println(a.toString());

        MyLinkedList<Integer> b = new MyLinkedList<>(1);
        b.addLast(2);
        b.addLast(3);

        a.merge(b);
        System.out.println("\n" + a.toString());
    }
}
