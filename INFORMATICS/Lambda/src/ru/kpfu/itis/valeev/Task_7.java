package ru.kpfu.itis.valeev;

import java.util.*;
import java.util.stream.Collectors;

public class Task_7 {

    public static void main(String[] args) {
        
        System.out.println("Task 7.4:");
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            list.add((int) (Math.random()*100) );
        }
        System.out.println(list.toString() + "\n");

        Comparator<Integer> comparator = new NavigableSetComparator();

        System.out.println(list.stream().sorted(comparator).collect(Collectors.toList()) + "\n");

        System.out.println("Task 7.5:");
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for(int i = 0; i < 20; i++){
            list1.add((int) (Math.random()*100) );
        }

        for(int i = 0; i < 10; i++){
            list2.add((int) (Math.random()*50) );
        }
        int maxElementInList2 = list2.stream().max(comparator).get();

        System.out.println(list1.toString() + "\n" + list2.toString() + "\n" + maxElementInList2);
        System.out.println(Arrays.toString(list1.stream().filter(x -> x > maxElementInList2).toArray()) + "\n");

        System.out.println("Task 7.6:");

        Set<String> set = new HashSet<>(); //Homework 7.6
        set.add("abcdefgeeeuuu");
        set.add("abcdefgeeuu");
        set.add("abcdefgeeyauuu");
        set.add("hmmmmmmmm");
        set.add("sssssssss");
        set.add("mmmmmmm");
        set.add("aaa");

        System.out.println(set.stream().filter(x -> {
            int count = 0;
            boolean flag = false;
            for(int i = 0; i<x.length() && !flag;i++){
                if(x.charAt(i) == 'e' ||
                        x.charAt(i) == 'u' ||
                        x.charAt(i) == 'y' ||
                        x.charAt(i) == 'i' ||
                        x.charAt(i) == 'o' ||
                        x.charAt(i) == 'a'){
                    count++;
                }
                if(count > 3) {
                    flag = true;
                }
            }
            return flag;
        }).count() + "\n");

        System.out.println("Task 7.7:");

        MyMap<Integer, Double> dictionary = new MyMap<>();
        for (int i = 1; i < 6; i++) {
            dictionary.put(i, Math.sqrt(i));
        }

        System.out.println(dictionary.keySet().stream().map(x -> "" + x).collect(Collectors.joining()) + "\n");

        System.out.println("Task 7.8:");

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("aaaaaaaaaaaa");
        stringList.add("bbbbbbbbb");
        stringList.add("ssa");
        stringList.add("cccccc");
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");

        System.out.println(stringList.stream().filter(x -> x.length() > 5).collect(Collectors.joining()));
    }
}
