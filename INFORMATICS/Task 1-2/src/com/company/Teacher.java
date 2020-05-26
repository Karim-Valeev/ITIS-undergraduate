package com.company;

import java.util.Comparator;

public class Teacher implements Comparator<Integer> {

    @Override
    public int compare(Integer grade, Integer otherGrade) {
        if(grade > otherGrade){ return grade-otherGrade; }
        else if(grade < otherGrade) return -1;
        else return 0;
    }
}
