package ru.kpfu.itis.valeev;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CircleList {

//    Эта структура данных нужна для экономии места
//    Т.е. можно перезаписывать старые ненужные элементы
//    Вся идея кольцевых структур в экономии памяти

    private class Participant implements Comparable<Participant>{
        private String name;
        private boolean gender;
        private Participant next;

        public Participant(String name, String gen, Participant next) {
            this.name = name;
            this.gender = gen.equals("male");
            this.next = next;
        }

        public Participant(boolean gen, String name, Participant next) {
            this.name = name;
            this.gender = gen;
            this.next = next;
        }

        public Participant(String name, boolean gender) {
            this.name = name;
            this.gender = gender;
        }

        public Participant(Participant otherP){
            this.name = otherP.name;
            this.gender = otherP.gender;
            this.next = otherP.next;
        }

        public String getName(){
            return this.name;
        }
        public boolean getGender(){
            return this.gender;
        }
        public void setNext(Participant next){
            this.next = next;
        }
        public Participant getNext(){
            return this.next;
        }

        @Override
        public int compareTo(Participant otherP){

            if (this.getName().equals(otherP.getName())) {
                if(this.getGender() == otherP.getGender()){
                    return 0;
                } else if(!this.getGender()) {
                    return -1;
                } else {
                    return 1;
                }
            }

            return this.getName().compareTo(otherP.getName());
        }
    }

    // Fields
    private Participant head;
    private Participant tail;
    private int size;

    //Constructors
    public CircleList(String filename) {

        try {
            File input = new File(filename);
            Scanner scanner = new Scanner(input);

            String buff = scanner.next();

            if(buff.equals("male") || buff.equals("female")){

                this.head = new Participant(buff.equals("male"), scanner.next(), null);
                Participant buf = this.head;
                this.size = 1;

                while (scanner.hasNext()){
                    buf.setNext(new Participant(scanner.next().equals("male"), scanner.next(), null));
                    buf = buf.getNext();
                    this.size++;
                }
                this.tail = buf;
            }else{

                this.head = new Participant(buff, scanner.next(), null);
                Participant buf = this.head;
                this.size = 1;

                while (scanner.hasNext()){
                    buf.setNext(new Participant(scanner.next(), scanner.next(),null));
                    buf = buf.getNext();
                    this.size++;
                }
                this.tail = buf;
            }
            this.tail.setNext(this.head);

            scanner.close();
        }catch (FileNotFoundException e){
            e.getMessage();
        }
    }

    public CircleList(Participant head) {
        this.head = head;
        this.tail = head;
        this.size = 1;
    }

    public CircleList() {}

    //    Methods
    public void show(){
        Participant buff = this.head;

        int spaceNum = buff.name.length();

        for(int i = 0; i < size-1; i++){
            if(buff.next.name.length() > buff.name.length()){
                spaceNum = buff.next.name.length();
            }
            buff = buff.next;
        }
        spaceNum+=4;

        String format = "%-" + spaceNum + "s";

        buff = this.head;



        for(int i = 0; i < size; i++){
            System.out.printf("%5d", i+1);
            System.out.printf(". " + format, buff.name + " ");
            System.out.println((buff.gender ? "male" : "female"));
            buff = buff.next;
        }
    }

    public void insert(String name, String gender){

        Participant buff = new Participant(name, gender, this.head);

        if(this.head == null){
            this.head = buff;
        }

        if(this.head.next == null){
            this.head.next = buff;
        }

        if(this.tail == null){
            this.tail = buff;
        }

        this.tail.next = buff;
        this.tail = buff;
        buff.next = this.head;
        size++;
    }

    public void insert(Participant p){
        Participant buff = new Participant(p);

        if(this.head == null){
            this.head = buff;
        }

        if(this.tail == null){
            this.tail = buff;
        }

        this.tail.next = buff;
        this.tail = buff;
        buff.next = this.head;
        size++;
    }

    public void delete(String name){

        if(this.size == 1){
            this.head = null;
            this.tail = null;
            return;
        }

        Participant buff1 = this.head;
        Participant buff2 = this.head.next;

        int c = 0;

        while(!name.equals(buff2.name)){

            c++;
            buff1 = buff2;
            buff2 = buff2.next;

            if(c >= this.size){
                throw new NoSuchElementException();
            }
        }
        size--;

        if(buff2.name.equals(this.head.name)){
            this.head = this.head.next;
            this.tail.next = this.head;
            return;
        }

        if(buff2.name.equals(this.tail.name)){
            this.tail = buff1;
            this.tail.next = this.head;
            return;
        }

        buff1.next = buff2.next;


//        Participant buff = this.tail;
//        int c = 0;
//
//        while(!name.equals(buff.next.name)){
//            System.out.println(c);
//            if (c == this.size()) {
//                throw new NoSuchElementException();
//            }
//            c++;
//            buff = buff.next;
//        }
//
//        buff.setNext(buff.next.next);
//
//        if(c == this.size -1){
//            this.head = buff.next;
//        }
//
//        if(buff.next.name.equals(this.tail.name)){
//            buff.next = this.head;
//            this.tail = buff;
//        }
//
//        size--;
    }

    public void swap(Participant  p1, Participant p2){
        if ( p1==p2 || p1 == null || p2 == null ){
            throw new IllegalArgumentException();
        }

        Participant buff = new Participant(p1);
        p1.name = p2.name;
        p1.gender = p2.gender;
        p2.name = buff.name;
        p2.gender = buff.gender;

    }

    public void sort(String name) {
        if(this.size() <= 50){
            this.bubbleSort(name);
        } else {
            this.sortUsingStringArray(name);
        }
    }

    public void bubbleSort(String name){

        Participant buff1 = this.head;
        Participant buff2 = this.head.next;

        for(int i = this.size-1; i > -1; i--){
            for(int j = 0; j < i; j++){
                if(buff1.compareTo(buff2) > 0){
                    swap(buff1, buff2);
                }
                buff1 = buff1.next;
                buff2 = buff2.next;
            }
            buff1 = this.head;
            buff2 = this.head.next;
        }
        buff1 = this.tail;

        int c = 0;

        while(!name.equals(buff1.next.name)){
            if(c == this.size()) {
                throw new NoSuchElementException();
            }
            buff1 = buff1.next;
            c++;

        }

        this.tail = buff1;
        this.head = buff1.next;
    }

    private String[] circleListToStringArray(CircleList l){

        String[] dataString = new String[l.size];
        Participant buff = l.head;

        for(int  i = 0; i< l.size; i++){
            dataString[i] = buff.getName() + ((buff.gender) ? " male" : " female");
            buff = buff.getNext();
        }

        return dataString;
    }

    public void sortUsingStringArray(String name) {

        String[] dataString = circleListToStringArray(this);
        Arrays.sort(dataString);

        String[] participantBuff = new String[2];

        participantBuff = dataString[0].split(" ");

        Participant p = new Participant(participantBuff[0], participantBuff[1].equals("male"));

        this.head = new Participant(p);
        this.tail = new Participant(p);
        this.size = 1;



        for (int i = 1; i < dataString.length; i++) {

            participantBuff = dataString[i].split(" ");
            this.insert(participantBuff[0], participantBuff[1]);

        }

        Participant buff = this.tail;

        int c = 0;

        while(!name.equals(buff.next.name)){
            if(c == this.size()) {
                throw new NoSuchElementException();
            }
            buff = buff.next;
            c++;
        }

        this.tail = buff;
        this.head = buff.next;
    }

    public Participant last(int k){
        int resNum;
        int res = 0;

        for (int i=1; i<= size; ++i) {
            res = (res + k) % i;
        }
        resNum = res + 1;

        Participant buff = this.head;
        for(int i = 0; i < resNum; i++){
            buff = buff.next;
        }
        return buff;
    }

    public CircleList[] gender(){
        CircleList m = new CircleList();
        CircleList f = new CircleList();

        Participant buff = this.head;

        for(int i = 0; i < this.size; i++){
            if(buff.gender){
                m.insert(buff.name, "male");
            }else{
                f.insert(buff.name, "female");
            }
            buff = buff.next;
        }

        CircleList[] result = new CircleList[2];
        result[0] = m;
        result[1] = f;
        return result;
    }

    public int size(){
        return  size;
    }

//    public static void main(String[] args) {
//
//        CircleList a = new CircleList("100.txt"); //Для проверки sortUsing...
//        a.show();
//
//        a.sortUsingStringArray("Hghpntymse");
//
//        a.show();
//
//        a.swap(a.head, a.head.getNext());
//        a.show();
//        System.out.println();
//        a.insert("a", "male");
//        a.delete("a");
//        a.show();
//
////        System.out.println();
////
////        CircleList b = new CircleList("test2.txt"); //Для проверки конструктора
////        b.show();
////
////
////        System.out.println();
////
////        CircleList[] mas = b.gender();
////
////        mas[0].show();
////        System.out.println();
////        mas[1].show();
//
//
//
//
//    }
}