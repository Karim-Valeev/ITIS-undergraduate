package ru.kpfu.itis.valeev;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

public class INIWriter extends OutputStream {

    BufferedWriter bw;

    public INIWriter(OutputStream out) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(out));
    }

    public void writeEntry(Map.Entry<String, String> e) {
        try{
            bw.write(e.getKey() + " = " + e.getValue() + '\n');
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void write(int i) throws IOException {
        bw.write(i);
    }

    @Override
    public void close() throws IOException{
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        INIWriter ini = new INIWriter(System.out);
        TreeMap<String,String> map = new TreeMap<>();
        map.put("key", "value");
        ini.writeEntry(map.firstEntry());
        ini.writeEntry(map.firstEntry());
        ini.writeEntry(map.firstEntry());
        ini.close();
    }

}
