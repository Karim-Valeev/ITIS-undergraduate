package ru.kpfu.itis.valeev;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int l = sc.nextInt();
//        HashSet<Integer> dic = new HashSet<>();
//        for(int i = 0; i< n; i++) {
//            dic.add(sc.nextInt());
//        }
//        int length = dic.size();
//        int[] a = new int[length];
//
//        Iterator<Integer> it = dic.iterator();

//        int j = 0;
//        while(it.hasNext()){
//            a[j] = it.next();
//            j++;
//        }
        int[] a = new int[n];
        for(int i =0; i< n; i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        double minMax = a[0];
        double buff = (l - a[n-1]);
        if(buff - minMax > 0) {
            minMax = buff;
        }

        for(int i = 0; i<n-1;i++){
            buff = (a[i+1] - a[i])/2.0;
            if(buff - minMax > 0){
                minMax = buff;
            }
        }

        out.print(minMax);
        out.flush();


    }

}
