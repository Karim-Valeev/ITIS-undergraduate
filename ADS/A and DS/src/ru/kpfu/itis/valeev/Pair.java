package ru.kpfu.itis.valeev;

public class Pair<T1, T2> {

    private T1 key;
    public T2 value;

    public Pair(T1 key, T2 value){
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString(){
        return "(" + key + " -> " + value + ")";
    }

    public T1 getKey() {
        return key;
    }
    public void setKey(T1 key){
        this.key = key;
    }

    public T2 getValue() {
        return value;
    }
    public void setValue(T2 value){
        this.value = value;
    }


    public T2 getValueByKey(T1 key){
        return value;
    }
}
