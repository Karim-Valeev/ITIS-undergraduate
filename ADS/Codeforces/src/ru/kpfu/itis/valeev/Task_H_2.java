package ru.kpfu.itis.valeev;

import java.io.PrintWriter;
import java.util.Scanner;

public class Task_H_2 {

    public static int counter = 0;
    public static int a;
    public static int b;
    public static int n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();

        if(a+3*b < n){
            out.print(0);
        } else{

            b = (b*3>n) ? (int) (b - (double) (b*3-n)/3) : b;
            Task_H_2 app = new Task_H_2();
            app.rec(0,a,b);
            out.print(counter%1000000009);

        }
        out.flush();

    }

    public void rec(int sum, int a2, int b2){

        if(sum == n){
            counter = (counter%1000000009 + 1) % 1000000009 ;
        }else if (sum<n){
            int sum1 = sum;
            int aa = a2;
            int bb = b2;
            if(aa>0){
                    sum1++;
                    aa--;
                    rec(sum1,aa,bb);
                    aa++;
                    sum1--;
            }
            if(bb>0){
                if(!(sum1 + 3*bb + aa < n)){
                    sum1+=3;
                    bb--;
                    rec(sum1,aa,bb);
                }

            }

        }
    }
}
