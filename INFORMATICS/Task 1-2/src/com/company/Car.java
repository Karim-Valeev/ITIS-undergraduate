package com.company;

import java.util.Comparator;

public class Car implements Comparator<Car>, Comparable<Car> {

    Car(double power){
        horsePowers = power;
    }

    public static double horsePowers;

    @Override
    public int compare(Car t, Car t1) {
        return ((int) t.horsePowers - (int) t1.horsePowers);
    }

    @Override
    public int compareTo(Car car) {
        return 0;
    }
}
