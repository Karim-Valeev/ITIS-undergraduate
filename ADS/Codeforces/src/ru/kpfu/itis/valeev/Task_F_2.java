package ru.kpfu.itis.valeev;

import java.io.PrintWriter;
import java.util.Scanner;

public class Task_F_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int[][] a = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < n; j++){
                a[i][j] = sc.nextInt();
            }
        }

        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = Math.max(i - 1 >= 0 ? f[i - 1][j] : 0, j - 1 >= 0 ? f[i][j - 1] : 0) + a[i][j];
            }
        }

        out.print(f[n-1][n-1]);
        out.flush();
    }
}
