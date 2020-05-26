package ru.kpfu.itis.valeev;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class TaskF {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int m = sc.nextInt();

        HashSet<String> dic = new HashSet<>(); // Если, что исправить

        String[] p = new String[n];
        String[] v = new String[m];

        String strBuf;
        sc.nextLine();
        int d=0;

        for(int i = 0 ; i<n; i++){
            strBuf = sc.nextLine();
            p[i] = strBuf;
            dic.add(strBuf);
        }

        for(int i = 0 ; i<m; i++){
            strBuf = sc.nextLine();
            v[i] = strBuf;
            if(!dic.add(strBuf)) d++;
        }

        if(d == 0){
            if(n>m) out.print("YES");
            else out.print("NO");
        } else if(d % 2 != 0){
            m -= (d/2 + 1);
            n -= (d/2);
            if(n>m) out.print("YES");
            else out.print("NO");
        } else {
            m -= (d/2);
            n -= (d/2);
            if(n>m) out.print("YES");
            else out.print("NO");
        }

        out.flush();

    }
}
