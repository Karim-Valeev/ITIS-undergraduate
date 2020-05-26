package ru.kpfu.itis.valeev;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);


        int m = sc.nextInt();
        int q,low,high,mid;

        for (int i=0;i<m;i++){
            q = sc.nextInt();

            if(a[0]>q) {
                out.print(0+"\n");
                continue;
            }else if(a[n-1]<=q) {
                out.print(n+"\n");
                continue;
            } else{
                low = 0;
                high = n-1;

                while (high - low != 1){
                    mid = (low+high+1)/2;

                    if(a[mid] > q){
                        high = mid;
                    } else if(a[mid]<=q){
                        low = mid;
                    } else if(a[mid] <= q && a[mid] > q){
                        System.out.println(mid + 1);
                        break;
                    }

                }

                out.print(high + "\n");


            }

        }
        out.flush();
    }
}
