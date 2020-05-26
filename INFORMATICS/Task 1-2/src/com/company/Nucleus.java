package com.company;

public class Nucleus implements Comparable<Nucleus>{

    private final int CHROMOSOMESAMOUNT;

    public Nucleus(int c){
        CHROMOSOMESAMOUNT = c;
    }

    @Override
    public int compareTo(Nucleus other) {
        if (CHROMOSOMESAMOUNT - other.CHROMOSOMESAMOUNT > 0) {
            return 1;
        } else if(CHROMOSOMESAMOUNT - other.CHROMOSOMESAMOUNT< 0){
            return -1;
        } else return 0;
    }
}
