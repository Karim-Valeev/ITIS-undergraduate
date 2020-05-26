package ru.kpfu.itis.valeev;

public class IntermittentBubbleSort {

    public void bubbleSort(int[] array){
        int a;
        for (int i = array.length-1; i >-1; i--){
            boolean flag = false;
            for (int j = 0; j < i; j++)
                if (array[j] > array[j+1]){

                    //swap(j,j+1);
                    a=array[j];
                    array[j] = array[j+1];
                    array[j+1] = a;

                    flag = true;

                }
            if (!flag) break;
        }
    }
}
