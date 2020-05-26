package ru.kpfu.itis.valeev;

import java.io.PrintWriter;
import java.util.*;

public class Task_A_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int deep = sc.nextInt();

        TreeMap<Integer,Integer> b = new TreeMap<>();
        TreeMap<Integer,Integer> s = new TreeMap<>();

        int p,q;
        char buff;

        for(int i = 0; i < n; i++){
            buff = sc.next().charAt(0);
            p = sc.nextInt();
            q = sc.nextInt();
            if(buff == 'B'){
                if(b.containsKey(p)){
                    b.put(p,b.get(p) + q);
                } else{
                    b.put(p,q);
                }
            } else{
                if(s.containsKey(p)){
                    s.put(p,s.get(p) + q);
                } else{
                    s.put(p,q);
                }
            }
        }

        Map.Entry<Integer,Integer> entry;
        if(s.size() >= deep){
            TreeMap<Integer,Integer> ss = new TreeMap<>();
            for (int i = 0; i < deep; i++){
                entry = s.pollFirstEntry();
                ss.put(entry.getKey(), entry.getValue());
            }
            for(int i = 1; i<=deep; i++){
                entry = ss.pollLastEntry();
                out.print("S " + entry.getKey()+ " " + entry.getValue() + "\n");
            }
        } else {
            while(!s.isEmpty()){
                entry = s.pollLastEntry();
                out.print("S " + entry.getKey()+ " " + entry.getValue() + "\n");
            }
        }


        for(int i = 1; i<=deep && !b.isEmpty(); i++){
            entry = b.pollLastEntry();
            out.print("B " + entry.getKey()+ " " + entry.getValue() + "\n");
        }

        out.flush();
    }

}
