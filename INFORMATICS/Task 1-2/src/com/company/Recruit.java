package com.company;

public class Recruit implements Comparable<Recruit>{

    private double weight;

    public  Recruit(double w){
        this.weight = w;
    }

    @Override
    public int compareTo(Recruit otherRecruit) {
        final double EXP = 1E-5;
        if (weight-otherRecruit.weight > 0) {
            return 1;
        } else if(Math.abs(weight-otherRecruit.weight) <= EXP){
            return 0;
        } else if(weight-otherRecruit.weight < 0){
            return -1;
        }
        return 0;
    }
}
