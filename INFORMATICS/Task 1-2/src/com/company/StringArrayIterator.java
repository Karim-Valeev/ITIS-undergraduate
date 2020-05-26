package com.company;

import java.util.Iterator;

public class StringArrayIterator implements Iterator<String> {

    public String[] data;
    private int cursor;

    public StringArrayIterator(String[] data){
        this.cursor = data.length-1;
        this.data = data;
    }

    public boolean hasNext() {
        return cursor>=0;

    }
    // поменяем условие чтобы шел через один и не видел null
//    Сдеалать дженериковским
    public String next() {
        try{
            while(data[cursor] == null) {
                cursor -= 2;
            }

            String el = data[cursor];

            cursor -= 2;
            return el;

        } catch (ArrayIndexOutOfBoundsException ex){
            throw new java.util.NoSuchElementException();
        }
    }

    public void nullMaker(){
        this.cursor = this.data.length -1;
    }

    public static void main(String[] args) {
        String[] a = {"s","a", "d",null, "ddd", "sdfsdf"};
        StringArrayIterator sai = new StringArrayIterator(a);

        for(int i =0; i<3; i++){
            System.out.println(sai.next());
        }


    }

}
