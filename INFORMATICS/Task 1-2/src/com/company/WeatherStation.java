package com.company;

import java.util.Comparator;

public class WeatherStation implements Comparator<Double> {


    @Override
    public int compare(Double yesterdayTemperature, Double todayTemperature){
        final double EXP = 1E-5;
        if (yesterdayTemperature-todayTemperature > 0) {
            return (int) (-1*(yesterdayTemperature-todayTemperature)) ;
        } else if(Math.abs(yesterdayTemperature-todayTemperature) <= EXP){
            return 0;
        } else if(yesterdayTemperature-todayTemperature < 0){
            return (int) (yesterdayTemperature-todayTemperature) ;
        }
        return 0;

    }
}
