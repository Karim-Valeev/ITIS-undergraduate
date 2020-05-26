package ru.kpfu.itis.valeev;

import java.util.HashSet;
import java.util.Scanner;

public class TaskG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] strArr = new String[n];
        for(int i = 0; i < n; i++){
            strArr[i] = sc.nextLine();
        }

        String  buff;

        HashSet<String> hs = new HashSet<>();

        for(int i = n-1; i>-1;i--){
            buff = strArr[i];
            if(hs.add(buff)){
                System.out.print(buff + '\n');
            }
        }

    }
}
