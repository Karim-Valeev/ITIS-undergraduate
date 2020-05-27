package ru.kpfu.itis.valeev;

import java.util.Arrays;
import java.util.Comparator;

public class Sorter<T> {

    private void recMergeSort(T[] arr, int n, Comparator<T> comparator){
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        T[] l = (T[]) new Object[mid];
        T[] r = (T[]) new Object[n-mid];

        System.arraycopy(arr, 0, l, 0, mid);
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
//        System.out.println(Arrays.toString(arr));
    }

    private void mergeSort (T[] a, Comparator<T> comparator) {
        T[] b = (T[]) new Object[a.length];
        int begin, end, i, j, m;

        for (int k=1; k < a.length; k *= 2 ) {
            for (int l=0; l+k < a.length; l += k*2 ) {
                begin = l + k;
                end = l + 2*k;

                if (end > a.length) end = a.length;

                m = l; i = l; j = begin;

                while (i < begin && j < end) {
                    if (comparator.compare(a[i],a[j]) <= 0) {
                        b[m] = a[i];
                        i++;
                    } else {
                        b[m] = a[j];
                        j++;
                    }
                    m++;
                }

                while (i < begin) {
                    b[m]=a[i];
                    i++;
                    m++;
                }

                while (j < end) {
                    b[m]=a[j];
                    j++;
                    m++;
                }

                for (m=l; m < end; m++) {
                    a[m] = b[m];
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {1,4,45,2,7,5,6,33,0,4};
        System.out.println(Arrays.toString(a));

        Sorter<Integer> sorter = new Sorter<>();

        sorter.recMergeSort(a,a.length,Comparator.comparingInt(x -> x));
        System.out.println(Arrays.toString(a) + "\n");

        Integer[] b = {34,65,7,888,-1,3,6,0,7,12};
        System.out.println(Arrays.toString(b));
        sorter.mergeSort(b,Comparator.comparingInt(x -> x));
        System.out.println(Arrays.toString(b));

    }

}
