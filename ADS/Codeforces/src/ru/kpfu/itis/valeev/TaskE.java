package ru.kpfu.itis.valeev;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TaskE {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();

        double[][] r = new double[n][2];


        int k, kSum = 0;

        int x,y;
        for(int i = 0; i < n; i++){
            x = sc.nextInt();
            y = sc.nextInt();
            r[i][0] = Math.sqrt(x*x+y*y);
            k = sc.nextInt();
            r[i][1] = k;
            kSum+=k;
        }

        if(kSum + s < 1000000){
            System.out.print(-1);
            return;
        }

        Arrays.sort(r, Comparator.comparingDouble(a -> a[0]));

        kSum = 0;
        for(int i = 0; i<n;i++){
            kSum+=r[i][1];
            if(s+kSum >=1000000){
                System.out.print(r[i][0]);
                return;
            }
        }

    }
}



