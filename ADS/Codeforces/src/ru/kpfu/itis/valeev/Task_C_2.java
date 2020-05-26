package ru.kpfu.itis.valeev;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Task_C_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int[] s = new int[120];
        int[][] g = new int[5][5];
        for(int i =0; i<5; i++){
            for(int j = 0; j<5; j++){
                g[i][j] = sc.nextInt();
            }
        }
        int c = 0;
        for(int i1 = 0; i1< 5; i1++){
            for(int i2 = 0; i2< 5; i2++){
                if(i2==i1) continue;
                for(int i3 = 0; i3< 5; i3++){
                    if(i3==i1 || i3==i2) continue;
                    for(int i4 = 0; i4< 5; i4++){
                        if(i4==i1 || i4==i2 || i4==i3) continue;
                        for(int i5 = 0; i5< 5; i5++){
                            if(i5==i1 || i5==i2 || i5==i3 || i5 == i4) continue;
                            s[c] = (g[i1][i2]+g[i2][i1]+g[i3][i4]+g[i4][i3])
                                    + (g[i2][i3]+g[i3][i2]+g[i4][i5]+g[i5][i4])
                                    + (g[i3][i4]+g[i4][i3])
                                    + (g[i4][i5]+g[i5][i4]);
                            c++;
                        }
                    }
                }
            }
        }

        Arrays.sort(s);
        out.print(s[119]);
        out.flush();

    }

}
