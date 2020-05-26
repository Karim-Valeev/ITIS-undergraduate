package ru.kpfu.itis.valeev;

import java.util.Comparator;

public class ReversedNavigableSetComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }

    @Override
    public Comparator<Integer> reversed() {
        return new NavigableSetComparator();
    }
}
