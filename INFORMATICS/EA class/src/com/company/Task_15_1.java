package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Task_15_1 {
    public static void main(String[] args) {
        divide();
        // ...
    }

    private static int denominator = 0;
    private static int weight = 0;
    public static String fileName = "somefile.text";
    //UNCHECKED
    // №1
    private static void divide() throws ArithmeticException{
        if (denominator!=0) {
            System.out.println("You can divide.");
        } else {
            throw new ArithmeticException("You can't divide by zero");
        }
    }

    private static void tester2() {
        try {
            loopedRecursion();
        } catch (StackOverflowError e) {
            throw new MyStackOverflowError("Too many loops.");
        }
    }

    //№3
    private static void tester3() {
        try {
            String str = "abc";
            int i = Integer.parseInt(str);
            System.out.println(i);
        } catch (NumberFormatException e) {
            throw new WronfFormatException("Please, change format." + "\n");
        }
    }

    //CHECKED
    //1
    private static void tester4() throws WeightlessException {
        if (weight == 0){
            throw new WeightlessException("If you aren't photon you should have weight.");
        }
    }

    //2
    private static void tester5() throws MyNullPointerException {
        try {
            throw new NullPointerException();
        }
        catch(NullPointerException e) {
            throw new MyNullPointerException("You can't do that.");
        }
    }

    //3
    private static void tester6() throws MyFileNotFoundException {
        if (fileName != "somefile.txt") {
            throw new MyFileNotFoundException("Where is it? I can't find it.");
        }

    }

    public static void loopedRecursion(){
        loopedRecursion();
    }
}
