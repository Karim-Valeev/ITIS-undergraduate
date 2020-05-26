package ru.kpfu.itis.valeev;

import java.io.*;
import java.util.Map;

public class INIReader extends InputStream {

    private class Entry<K, V> implements Map.Entry<K,V>{

        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public Object setValue(Object o) {
            V buff = value;
            value = (V) o;
            return buff;
        }
    }

    private BufferedReader br;

    public INIReader(InputStream in) throws IOException {
        br = new BufferedReader(new InputStreamReader(in));
    }

    public Map.Entry<String, String> readEntry() throws IOException {
        try{
            String buff = br.readLine();
            String key;
            String value;
            int index = buff.indexOf(" = ");
            if(index != -1){
                key = buff.substring(0,index);
                value = buff.substring(index+3);
                return new Entry(key,value);
            } else {
                return null;
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public int read() throws IOException {
        return br.read();
    }

    @Override
    public void close() throws IOException{
        br.close();
    }

}

