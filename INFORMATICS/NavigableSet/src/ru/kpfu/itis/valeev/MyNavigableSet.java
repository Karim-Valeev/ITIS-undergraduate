package ru.kpfu.itis.valeev;

import java.util.*;

/**
 * @author Karim Valeev
 * @version 1.0
 * @param <T> Type of contains element
 */
public class MyNavigableSet<T> extends AbstractCollection<T> implements NavigableSet<T> {
    /**
     * Fields
     */
    private ArrayList<T> data = new ArrayList<>();
    private int size;
    private Comparator<? super T> comparator;

    /**
     * @param collection
     * @param comparator
     */
    public MyNavigableSet(Collection<? extends T> collection, Comparator<? super T> comparator) {
        this.comparator = comparator;
        this.addAll(collection);
        size = collection.size();
    }

    public MyNavigableSet(Comparator<? super T> comparator) {
        this.comparator = comparator;
        size = 0;
    }

    public MyNavigableSet(SortedSet<T> sortedSet) {
        this.comparator = sortedSet.comparator();
        data.addAll(sortedSet);
        size = sortedSet.size();
    }

    /**
     * <p>Add element to set</p>
     * @param t Element to add
     * @return Is element added
     */
    @Override
    public boolean add(T t) {
        if (data.size() == 0) {
            data.add(t);
            return true;
        }

        if (data.contains(t)) {
            return false;
        }

        for (T e : data) {
            if (comparator.compare(e, t) > 0) {
                data.add(data.indexOf(e), t);
                return true;
            }
        }

        data.add(t);
        return true;
    }

    /**
     * <p>Returns the greatest element less then given element or null if there no such file</p>
     * @param t Element of set
     * @return Element standing behind t in order
     */
    @Override
    public T lower(T t) {
        int c = 0;
        T low = t;

        for(T buff : data){
            if(comparator.compare(buff,t)<0){
                low = buff;
                c++;
            }
        }

        if (c != 0) return low;
        else return null;
    }

    /**
     * <p>Returns the greatest element less then or equal to given element</p>
     * @param t given element
     * @return result
     */
    @Override
    public T floor(T t) {
        int c = 0;
        T floor = t;

        for(T buff : data){
            if(comparator.compare(buff,t) <= 0){
                floor = buff;
                c++;
            }
        }

        if (c != 0) return floor;
        else return null;
    }

    /**
     * <p>Returns the least element greater then or equal to given element</p>
     * @param t given element
     * @return result
     */
    @Override
    public T ceiling(T t) {
        for(T buff : data){
            if(comparator.compare(buff,t) >= 0){
                return buff;
            }
        }

        return null;
    }

    /**
     * <p>Returns the least element greater then given element</p>
     * @param t given element
     * @return result
     */
    @Override
    public T higher(T t) {
        for(T buff : data){
            if(comparator.compare(buff,t)>0){
                return buff;
            }
        }

        return null;
    }

    /**
     * <p>Removes and returns least element</p>
     * @return least element
     */
    @Override
    public T pollFirst() {
        if(size == 0) return null;
        else return data.remove(0);
    }

    /**
     * <p>Removes and returns greatest element</p>
     * @return greatest element
     */
    @Override
    public T pollLast() {
        if(size == 0) return null;
        else return data.remove(data.size() - 1);
    }

    /**
     *
     * @return iterator
     */
    @Override
    public Iterator<T> iterator() {
        return data.iterator();
    }

    /**
     * <p>Return set with reverse direction</p>
     * @return set
     */
    @Override
    public NavigableSet<T> descendingSet() {
        return new MyNavigableSet<>(data, comparator.reversed());
    }

    /**
     * <p>Return iterator with reverse direction</p>
     * @return descending iterator
     */
    @Override
    public Iterator<T> descendingIterator() {
        return descendingSet().iterator();
    }

    /**
     * <p>returns part of set</p>
     * @param fromElement Start element
     * @param fromInclusive Include start element
     * @param toElement Finish element
     * @param toInclusive Include finish element
     * @throws IllegalArgumentException
     * @return new set
     */
    @Override
    public NavigableSet<T> subSet(T fromElement, boolean fromInclusive, T toElement, boolean toInclusive) {
        if(data.indexOf(fromElement) > data.indexOf(toElement)){
            throw new IllegalArgumentException();
        }

        ArrayList<T> newList = new ArrayList<>();
        int indexFrom, indexTo;
        indexFrom = fromInclusive ? data.indexOf(ceiling(fromElement)) : data.indexOf(higher(fromElement));
        indexTo = toInclusive ? data.indexOf(floor(toElement)) : data.indexOf(lower(toElement));

        for (int i = indexFrom; i <= indexTo; i++) {
            newList.add(data.get(i));
        }

        return new MyNavigableSet<>(newList, comparator);
    }

    /**
     * <p>Returns subset with start in first element</p>
     * @param toElement Finish element
     * @param inclusive Include finish element
     * @throws IllegalArgumentException
     * @return new set
     */
    @Override
    public NavigableSet<T> headSet(T toElement, boolean inclusive) {
        return subSet(first(), true, toElement, inclusive);
    }

    /**
     * <p>Returns subset with finish in last element</p>
     * @param fromElement Start element
     * @param inclusive Include start element
     * @throws IllegalArgumentException
     * @return new set
     */
    @Override
    public NavigableSet<T> tailSet(T fromElement, boolean inclusive) {
        return subSet(fromElement, inclusive, last(), true);
    }

    /**
     * <p>Returns comparator</p>
     * @return comparator
     */
    @Override
    public Comparator<? super T> comparator() {
        return comparator;
    }

    /**
     * <p>Subset with included start element and excluded finish element</p>
     * @param fromElement Start element
     * @param toElement Finish element
     * @return new set
     */
    @Override
    public SortedSet<T> subSet(T fromElement, T toElement) {
        return subSet(fromElement, true, toElement, false);
    }

    /**
     * <p>Head set with excluded finish element</p>
     * @param toElement Finish element
     * @return new set
     */
    @Override
    public SortedSet<T> headSet(T toElement) {
        return headSet(toElement, false);
    }

    /**
     * <p>Tail set with included start element</p>
     * @param fromElement Start element
     * @return new set
     */
    @Override
    public SortedSet<T> tailSet(T fromElement) {
        return tailSet(fromElement, true);
    }

    /**
     *
     * @return first element
     */
    @Override
    public T first() {
        return data.get(0);
    }

    /**
     *
     * @return last element
     */
    @Override
    public T last() {
        return data.get(data.size() - 1);
    }

    /**
     *
     * @return amount of elements
     */
    @Override
    public int size() {
        return data.size()  ;
    }

    /**
     *
     * @return console view of set
     */
    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
