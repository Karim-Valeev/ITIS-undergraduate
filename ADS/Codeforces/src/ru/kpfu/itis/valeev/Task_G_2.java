package ru.kpfu.itis.valeev;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Task_G_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] h = new int[n];
        int[][] s = new int[n-k+1][2];

        int sumBuff = 0;

        for(int i = 0; i<k; i++){
            h[i] = sc.nextInt();
            sumBuff+=h[i];
        }

        s[0][0] = sumBuff;
        s[0][1] = 1;

        for(int i = k; i<n; i++){
            h[i] = sc.nextInt();
            sumBuff -= h[i-k];
            sumBuff += h[i];
            s[i-k+1][0] = sumBuff;
            s[i-k+1][1] = i-k+2;
        }

        Arrays.sort(s, Comparator.comparingInt(a -> a[0]));
        out.print(s[0][1]);
        out.flush();

    }

}
