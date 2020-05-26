package com.company;

public class SportsCar implements Comparable<SportsCar> {

    private double accelerationTo100;

    public  SportsCar(double t){
        this.accelerationTo100 = t;
    }

    @Override
    public int compareTo(SportsCar otherSportsCar) {
        final double EXP = 1E-5;
        if (accelerationTo100-otherSportsCar.accelerationTo100 > 0) {
            return 1;
        } else if(Math.abs(accelerationTo100-otherSportsCar.accelerationTo100) <= EXP){
            return 0;
        } else if(accelerationTo100-otherSportsCar.accelerationTo100 < 0){
            return -1;
        }
        return 0;
    }

}
