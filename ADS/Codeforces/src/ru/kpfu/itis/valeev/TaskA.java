package ru.kpfu.itis.valeev;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] a = new int[n];

        for (int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        int m = sc.nextInt();
        int q,low,high,mid;

        for (int  i = 0; i<m; i++){
            q = sc.nextInt();
            if(a[0]>=q) {
                System.out.print(0+" ");
                continue;
            }else if(a[n-1]<q) {
                System.out.print(n+" ");
                continue;
            } else{
                low = 0;
                high = n-1;
                while (high - low != 1){
                    mid = (low+high+1)/2;
                    if(a[mid] > q){
                        high = mid;
                    } else if(a[mid]<q){
                        low = mid;
                    } else{
                        while (a[mid-1] == q){
                            mid--;
                        }
                        high = mid;
                        low = mid-1;
                    }
                }

                System.out.print(high + " ");

            }

        }
    }
}
