package ru.kpfu.itis.valeev;

import java.util.AbstractMap;
import java.util.Set;

public class MyMap<K,V> extends AbstractMap<K,V> {
    protected Set<Entry<K, V>> entrySet;

    protected MyMap(){
        entrySet = new SpecialSet<>();
    }

    public MyMap(Set<Entry<K, V>> entrySet) {
        this.entrySet = entrySet;
    }

    @Override
    public V put(K key, V value) {
        if (keySet().contains(key)){
            Entry<K, V> newEntry = new SimpleEntry<>(key, value);
            V previous = remove(key);
            entrySet().add(newEntry);
            return previous;
        }else {
            Entry<K, V> newEntry = new SimpleEntry<>(key, value);
            entrySet().add(newEntry);
            return null;
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return entrySet;
    }

}
