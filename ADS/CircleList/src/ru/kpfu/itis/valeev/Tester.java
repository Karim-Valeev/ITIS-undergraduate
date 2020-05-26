package ru.kpfu.itis.valeev;

import java.io.FileNotFoundException;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class Tester {

    public static String[] specialStringArrayGenerator(int size){
        String[] str = new String[size];
        char[] s = new char[10];

        for(int i = 0; i < size; i++){
            for(int j =0; j<10; j++){
                s[j] = (char) ((int) (97 + Math.random()*25 ));
            }

            s[0] = Character.toUpperCase(s[0]);

            str[i] = (Math.random() > 0.5) ? new String(s) + " male" : new String(s) + " female";
        }

        return str;
    }

    public static void newData(String[] array) throws IOException {
        int n = array.length;
        String fileName = n + ".txt";

        FileWriter fw = new FileWriter( fileName);
        for(int  i = 0; i<n; i++){
            fw.write(array[i] + "\n");
        }
        fw.close();
    }

    public static void main(String[] args) throws IOException {

        //GENERATOR
//        Tester.newData(Tester.specialStringArrayGenerator(100));
//        Tester.newData(Tester.specialStringArrayGenerator(500));
//        Tester.newData(Tester.specialStringArrayGenerator(1000));

        FileWriter fw = new FileWriter("results.txt");
        long t0, t1, average = 0;
        CircleList a;

//        usedBytes = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
//        a = new CircleList("1000.txt");
//        usedBytes = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) - usedBytes;
//        fw.write( usedBytes/1024 + " kb" + "\n" + "\n");


        // Constructors
        for(int i = 0; i < 100; i++){

            t0 = System.nanoTime();
            a = new CircleList();
            t1 = System.nanoTime();
            average+=(t1 - t0)/1000/100;

        }
        fw.write( "Empty constructor take in average: "+ average + " microseconds"+  "\n" + "\n");
        average=0;

        for(int i = 0; i < 100; i++){

            t0 = System.nanoTime();
            a = new CircleList("100.txt");
            t1 = System.nanoTime();
            average+=(t1 - t0)/1000/100;

        }
        fw.write( "Constructor for 100 elements take in average: "+ average + " microseconds"+  "\n" + "\n");
        average=0;

        for(int i = 0; i < 100; i++){

            t0 = System.nanoTime();
            a = new CircleList("500.txt");
            t1 = System.nanoTime();
            average+=(t1 - t0)/1000/100;

        }
        fw.write( "Constructor for 500 elements take in average: "+ average + " microseconds"+  "\n" + "\n");
        average=0;

        for(int i = 0; i < 100; i++){

            t0 = System.nanoTime();
            a = new CircleList("1000.txt");
            t1 = System.nanoTime();
            average+=(t1 - t0)/1000/100;

        }
        fw.write( "Constructor for 1000 elements take: "+ average + " microseconds" + "\n" + "\n");
        average=0;

        // show() methods for 100, 500, 1000x
        CircleList b,c,d;
        b = new CircleList("100.txt");
        c = new CircleList("500.txt");
        d = new CircleList("1000.txt");
        long t2, t3, t4, t5, average1 = 0, average2 = 0, average3 = 0;

        for(int i = 0; i < 100; i++){
            t0 = System.nanoTime();
            b.show();
            t1 = System.nanoTime();
            average1+=(t1 - t0)/100;

            t2 = System.nanoTime();
            c.show();
            t3 = System.nanoTime();
            average2+=(t3 - t2)/100;

            t4 = System.nanoTime();
            d.show();
            t5 = System.nanoTime();
            average3+=(t5 - t4)/100;
        }

        fw.write( "show() for 100 take in average: "+ average1/ 1000 + " microseconds"+  "\n" + "\n");
        fw.write( "show() for 500 take in average: "+ average2/ 1000 + " microseconds"+  "\n" + "\n");
        fw.write( "show() for 1000 take in average: "+ average3 / 1000  + " microseconds"+  "\n" + "\n");
        average1 = 0;
        average2 = 0;
        average3 = 0;

        // insert() and delete()
        a = new CircleList("10.txt");
        String name, gender;

        for(int i = 0; i < 100; i++){
            name = i+1+". Participant";
            gender = (Math.random() > 0.5) ? "male" : "female";

            t0 = System.nanoTime();
            a.insert(name,gender);
            t1 = System.nanoTime();
            average1 += (t1 - t0)/100;

            t2 = System.nanoTime();
            a.delete(name);
            t3 = System.nanoTime();
            average2 += (t3 - t2)/100;
        }

        fw.write( "insert() take in average: "+ average1 + " nanoseconds"+  "\n" + "\n");
        fw.write( "delete() take in average: "+ average2 + " nanoseconds"+  "\n" + "\n");
        average1 = 0;
        average2 = 0;

        // sort()
        long t6,t7,t8,t9,t10,t11,t12,
                average4 = 0,
                average5 = 0,
                average6 = 0;

        for(int i = 0; i < 100; i++){

            b = new CircleList("100.txt");
            t1 = System.nanoTime();
            b.bubbleSort("Xvvtrmkuub");
            t2 = System.nanoTime();
            average1+=(t2 - t1)/100;

            t3 = System.nanoTime();
            b.sortUsingStringArray("Xvvtrmkuub");
            t4 = System.nanoTime();
            average2+=(t4 - t3)/100;

            c = new CircleList("500.txt");
            t5 = System.nanoTime();
            c.bubbleSort("Uhkbhernxj");
            t6 = System.nanoTime();
            average3+=(t6 - t5)/100;

            t7 = System.nanoTime();
            c.sortUsingStringArray("Uhkbhernxj");
            t8 = System.nanoTime();
            average4+=(t8 - t7)/100;

            d = new CircleList("1000.txt");
            t9 = System.nanoTime();
            d.bubbleSort("Pdrjkbeons");
            t10 = System.nanoTime();
            average5+=(t10 - t9)/100;

            t11 = System.nanoTime();
            d.sortUsingStringArray("Pdrjkbeons");
            t12 = System.nanoTime();
            average6+=(t12 - t11)/100;
        }
        fw.write( "bubbleSort() for 100 take in average: "+ average1 + " nanoseconds"+  "\n" + "\n");
        fw.write( "sortUsingStringArray() for 100 take in average: "+ average2+ " nanoseconds"+  "\n" + "\n");
        fw.write( "bubbleSort() for 500 take in average: "+ average3 / 1000  + " microseconds"+  "\n" + "\n");
        fw.write( "sortUsingStringArray()  for 500 take in average: "+ average4/ 1000 + " microseconds"+  "\n" + "\n");
        fw.write( "bubbleSort() for 1000 take in average: "+ average5/ 1000 + " microseconds"+  "\n" + "\n");
        fw.write( "sortUsingStringArray()  for 1000 take in average: "+ average6 / 1000  + " microseconds"+  "\n" + "\n");
        average1 = 0;
        average2 = 0;
        average3 = 0;
        average4 = 0;
        average5 = 0;
        average6 = 0;

        // last() methods
        a = new CircleList("100.txt");
        for(int i = 0; i < 100; i++){

            t0 = System.nanoTime();
            a.last(25);
            t1 = System.nanoTime();
            average+=(t1 - t0)/100;

        }
        fw.write( "last() for 100 elements take in average: "+ average + " nanoseconds" + "\n" + "\n");
        average=0;

        a = new CircleList("500.txt");
        for(int i = 0; i < 100; i++){

            t0 = System.nanoTime();
            a.last(125);
            t1 = System.nanoTime();
            average+=(t1 - t0)/100;

        }
        fw.write( "last() for 500 elements take in average: "+ average + " nanoseconds"+  "\n" + "\n");
        average=0;

        a = new CircleList("1000.txt");
        for(int i = 0; i < 100; i++){

            t0 = System.nanoTime();
            a.last(250);
            t1 = System.nanoTime();
            average+=(t1 - t0)/100;

        }
        fw.write( "last() for 1000 elements take in average: "+ average + " nanoseconds"+ "\n" + "\n");
        average=0;

        // gender()
        for(int i = 0; i < 100; i++){

            b = new CircleList("100.txt");
            t1 = System.nanoTime();
            b.gender();
            t2 = System.nanoTime();
            average1+=(t2 - t1)/100;

            c = new CircleList("500.txt");
            t3 = System.nanoTime();
            c.gender();
            t4 = System.nanoTime();
            average2+=(t4 - t3)/100;

            d = new CircleList("1000.txt");
            t5 = System.nanoTime();
            d.gender();
            t6 = System.nanoTime();
            average3+=(t6 - t5)/100;

        }
        fw.write( "gender() for 100 take in average: "+ average1 + " nanoseconds"+  "\n" + "\n");
        fw.write( "gender() for 500 take in average: "+ average2 + " nanoseconds"+  "\n" + "\n");
        fw.write( "gender() for 1000 take in average: "+ average3 + " nanoseconds"+  "\n" + "\n");
        average1 = 0;
        average2 = 0;
        average3 = 0;

        // Memory measurement:

        fw.close();
    }
}
