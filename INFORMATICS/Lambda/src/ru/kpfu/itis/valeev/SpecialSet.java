package ru.kpfu.itis.valeev;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;

public class SpecialSet<T> extends AbstractSet<T> {

    private ArrayList<T> set;

    public SpecialSet() {
        set = new ArrayList<>();
    }

    @Override
    public boolean add(T e) {
        if (this.contains(e)) {
            return false;
        }
        set.add(e);
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }

    @Override
    public boolean contains(Object element) {
        return set.contains(element);
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean remove(Object e){
        if (this.contains(e)){
            set.remove(e);
            return true;
        }
        return false;
    }
}
