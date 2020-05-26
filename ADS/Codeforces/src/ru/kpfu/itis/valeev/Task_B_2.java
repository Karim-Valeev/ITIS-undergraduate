package ru.kpfu.itis.valeev;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_B_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();

        HashMap<String,Integer> map = new HashMap<>();
        map.put("polycarp",1);

        String str1, str2;
        for(int i = 0; i<n; i++){
            str1 = sc.next().toLowerCase();
            sc.next();
            str2 = sc.next().toLowerCase();
            map.put(str1, map.get(str2) + 1);
        }

        int max = 0;

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue()>max){
                max = entry.getValue();
            }
        }

        out.println();
        out.println(max);
        out.flush();

    }
}
