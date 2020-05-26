package ru.kpfu.itis.valeev;

import java.util.Comparator;

public class NavigableSetComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }

    @Override
    public Comparator<Integer> reversed() {
        return new ReversedNavigableSetComparator();
    }
}
