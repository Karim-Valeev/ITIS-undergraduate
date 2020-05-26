package com.company;

import java.util.ArrayList;

public class WeightBubbleSorter {

    public static void courseBubbleSort(EndlessArray<Recruit> list){
        for(int i = list.getSize()-1; i >-1; i--){
            for (int j = 0; j < i; j++){
                if (list.get(j).compareTo(list.get(j+1)) > 0){
                    list.swap(j,j+1);
                }
            }
        }
    }


}
