package ru.kpfu.itis.valeev;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Task_D_2 {

    public static int[] R;
    public static int[] L;
    public static int[] v;
    public static int cc = 0;
    public static int n = 0;
    public static int m = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        int[][] b = new int[n][m+2];
        R = new int[n];
        L = new int[n];

        v = new int[(int)Math.pow(2,n)];

        int j;
        String[] str = new String[m+2];
        for(int i = 0; i<n ; i++){
            str[i] = sc.nextLine();
            j = 0;
            for(int k = 0; k<m+1; k++){
                if(str[i].charAt(k)-48 == 1){
                    j = k;
                    break;
                }
            }
            L[i] = j;

            if (j != 0) {
                j = 0;
                for (int k = m + 1; k > 0; k--) {
                    if (str[i].charAt(k)-48 == 1) {
                        j = k;
                        break;
                    }
                }
            }
            R[i] = j;
        }

        int k = 0;
        while(L[k] ==0){
            k++;
            if(k==n) break;
        }
        int c = n-1 -k;

        int cursor;
        int min = 0;

        if(L[n-1] != 0 ){
            min = R[n-1];
            cursor = min;
        } else {
            cursor = 0;
        }

        rec(cursor,n-2,min,0);
        rec(cursor,n-2,min,1);

        Arrays.sort(v);
        min = v[0];
        if(min==0) {
            out.print(min);
        }else {
            out.print(min + c);
        }
        out.flush();
    }

    public static void rec(int cursor, int i, int min, int index){
        if(i == -1){
            v[cc] = min;
            cc++;
        } else {
            int cursor2 = cursor;
            int ii = i;
            int minB = min;
            if(L[ii] != 0){
                if(index == 0){
                    minB += R[ii] + cursor2;
                    cursor2 = R[ii];
                }else{
                    minB += m+2-cursor+m - L[ii];
                    cursor2 = L[ii];
                }

            }
            ii--;
            rec(cursor2,ii,minB,0);
            rec(cursor2,ii,minB,1);
        }



    }

}
