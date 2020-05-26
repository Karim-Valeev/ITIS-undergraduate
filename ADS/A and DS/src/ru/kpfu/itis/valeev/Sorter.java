package ru.kpfu.itis.valeev;

import java.util.Arrays;
import java.util.Comparator;

public class Sorter<T> {

    public void recMergeSort(T[] arr, int n, Comparator<T> comparator){
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        T[] l = (T[]) new Object[mid];
        T[] r = (T[]) new Object[n-mid];

        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = arr[i];
        }

        recMergeSort(l, mid, comparator);
        recMergeSort(r, n - mid, comparator);

        int left = mid, right = n-mid;
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (comparator.compare(l[i],r[j]) <= 0) {
                arr[k] = l[i];
                k++;
                i++;
            }
            else {
                arr[k] = r[j];
                k++;
                j++;
            }
        }
        while (i < left) {
            arr[k] = l[i];
            k++;
            i++;
        }
        while (j < right) {
            arr[k] = r[j];
            k++;
            j++;
        }
    }



    public void mergeSort(T[] arr, Comparator<T> comparator){
        int l = arr.length;

        int n = 1, i;
        while(n<l){
            i = 0;
            while(i < l - n){

                i = i + 2*n;
            }
            n*=2;
        }

//        m = 1
//        while m < n do
//            i = 0
//        while i < n-m do
//            merge subarrays a[i..i+m-1] and a[i+m .. min(i+2*m-1,n-1)] in-place.
//                i = i + 2 * m
//        m = m * 2

    }

    public static void main(String[] args) {
        System.out.println( ((double) 3.8/2));
//        Integer[] a = {1,4,45,2,5,6,33,0,4};
//        System.out.println(Arrays.toString(a));
//
//        Sorter<Integer> sorter = new Sorter<>();
//
//        sorter.recMergeSort(a,a.length,Comparator.comparingInt(x -> x));
//        System.out.println(Arrays.toString(a));
//
//        sorter.recMergeSort(a,a.length,Comparator.comparingInt(x -> x));
//        System.out.println(Arrays.toString(a));

    }

}
