package ru.kpfu.itis.valeev;

import java.io.FileNotFoundException;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class TimeTester {

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

        FileWriter fw = new FileWriter(fileName);
        for(int  i = 0; i<n; i++){
            fw.write(array[i] + "\n");
        }
        fw.close();
    }

    public static void emptyConstructorResult(String fileName) throws IOException {
        long t0, t1, average = 0;
        FileWriter fw = new FileWriter(fileName);
        CircleList a;

        for(int i = 10; i < 1001; i+=10){
            for (int j = 0; j <10; j++){
                t0 = System.nanoTime();
                a = new CircleList();
                t1 = System.nanoTime();
                average+=(t1 - t0)/10;
            }
            fw.write( average + "\n");
            average = 0;
        }
        fw.close();
    }

    public static void constructorResult(String fileName) throws IOException {
        long t0, t1, average = 0;
        FileWriter fw = new FileWriter(fileName);
        CircleList a;

        for(int i = 10; i < 1001; i+=10){
            for (int j = 0; j <10; j++){
                t0 = System.nanoTime();
                a = new CircleList("src/data/" + i + ".txt");
                t1 = System.nanoTime();
                average+=(t1 - t0)/10;
            }
            fw.write( average + "\n");
            average = 0;
        }
        fw.close();
    }

    public static void showResult(String fileName) throws IOException {
        long t0, t1, average = 0;
        FileWriter fw = new FileWriter(fileName);
        CircleList a;

        for(int i = 10; i < 1001; i+=10){
            for (int j = 0; j <10; j++){
                a = new CircleList("src/data/" + i + ".txt");
                t0 = System.nanoTime();
                a.show();
                t1 = System.nanoTime();
                average+=(t1 - t0)/10;
            }
            fw.write( average + "\n");
            average = 0;
        }
        fw.close();
    }

    public static void insertDeleteResult(String fileName1, String fileName2) throws IOException {
        long t0, t1,t2,t3, average1 = 0, average2 = 0;
        FileWriter fw1 = new FileWriter(fileName1);
        FileWriter fw2 = new FileWriter(fileName2);
        CircleList a;
        String name, gender;

        for(int i = 10; i < 1001; i+=10){
            a = new CircleList("src/data/" + i + ".txt");
            for (int j = 0; j <10; j++){
                name = i+1+". Participant";
                gender = (Math.random() > 0.5) ? "male" : "female";

                t0 = System.nanoTime();
                a.insert(name,gender);
                t1 = System.nanoTime();
                average1 += (t1 - t0)/10;

                t2 = System.nanoTime();
                a.delete(name);
                t3 = System.nanoTime();
                average2 += (t3 - t2)/10;
            }
            fw1.write( average1 + "\n");
            fw2.write( average2 + "\n");
            average1 = 0; average2 = 0;
        }
        fw1.close();
        fw2.close();
    }

    public static void sortResult(String fileName) throws IOException {
        long t0,t1, average = 0;
        FileWriter fw = new FileWriter(fileName);
        CircleList a;

        for(int i = 10; i < 1001; i+=10){
            for (int j = 0; j <10; j++){
                a = new CircleList("src/data/" + i + ".txt");
                a.insert("Aaaaaaaaaa","male");
                t0 = System.nanoTime();
                a.sort("Aaaaaaaaaa");
                t1 = System.nanoTime();
                average+=(t1 - t0)/10;
            }
            fw.write( average + "\n");
            average = 0;
        }
        fw.close();
    }

    public static void lastResult(String fileName) throws IOException {
        long t0,t1, average = 0;
        FileWriter fw = new FileWriter(fileName);
        CircleList a;

        for(int i = 10; i < 1001; i+=10){
            a = new CircleList("src/data/" + i + ".txt");
            for (int j = 0; j <10; j++){
                t0 = System.nanoTime();
                a.last(a.size()/2);
                t1 = System.nanoTime();
                average+=(t1 - t0)/100;
            }
            fw.write( average + "\n");
            average = 0;
        }
        fw.close();
    }

    public static void genderResult(String fileName) throws IOException {
        long t0,t1, average = 0;
        FileWriter fw = new FileWriter(fileName);
        CircleList a;

        for(int i = 10; i < 1001; i+=10){
            for (int j = 0; j <10; j++){
                a = new CircleList("src/data/" + i + ".txt");
                t0 = System.nanoTime();
                a.gender();
                t1 = System.nanoTime();
                average+=(t1 - t0)/10;
            }
            fw.write( average + "\n");
            average = 0;
        }
        fw.close();
    }

    public static void main(String[] args) throws IOException {

        emptyConstructorResult("EmptyConstructor.txt");
        constructorResult("Constructor.txt");
        showResult("show.txt");
        insertDeleteResult("insert.txt", "delete.txt");
        sortResult("sort.txt");
        lastResult("last.txt");
        genderResult("gender.txt");


    }

}
