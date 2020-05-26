package ru.kpfu.itis.valeev;

public class Test {

    public static int size;

    public int last(int k){
        boolean[] arr = new boolean[size];
        for(int j = 0; j<arr.length; j++){
            arr[j] = true;
        }
        int j = 0;
        int trueCounter = 0;
        int c = 0;

        while (true) {
            int buffer = j;

            if (j+1 == arr.length){
                j = 0;
            } else { j++; }

            while(! arr[j]){
                c++;
                j++;
                if (j == arr.length){
                    j = 0;
                }
                if(c == arr.length-1) return buffer;

            }

            trueCounter++;
            if(trueCounter == k){
                arr[j] = false;
                trueCounter = 0;
            }

            c = 0;
        }

    }

    public static void main(String[] args) {
        Test t = new Test();
        int[] a = new int[6];
        size = 6;
        System.out.println(t.last(2));
    }
}
