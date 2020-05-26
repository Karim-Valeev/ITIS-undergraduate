package ru.kpfu.itis.valeev;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class TaskD {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n+1];

        a[0] = 0;
        int sum = 0;
        for (int i=1;i<n+1;i++){
            sum += sc.nextInt() * sc.nextInt();
            a[i] = sum;

        }

        Arrays.sort(a);

        int v,low,high,mid;
        for (int i = 0; i<m; i++){
            v = sc.nextInt();

            low =1;
            high = n;

            if(a[1]>=v){
                out.print(1 + "\n");
                continue;
            }

            while(high - low !=1){
                mid = (low+high)/2;

                if(a[mid]>v){
                    high = mid;
                } else if(a[mid]<v){
                    low = mid;
                }

                if(a[mid]>=v && a[mid-1] < v) {
                    high = mid;
                    low = mid-1;
                }
            }
            out.print(high + "\n");
        }

        out.flush();

    }

}
