package ru.kpfu.itis.valeev;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class IOStream {

    public static void main(String[] args) {
        final String path = "test.txt";

        File file = new File(path);

        int i = 12;
        char c = 'а';
        byte byte1,
                byte2,
                byte3,
                byte4,
                byte5,
                byte6;

        // Task 8.3
        try(FileOutputStream out = new FileOutputStream(file)) {
            out.write(i>>24);
            out.write(i>>16);
            out.write(i>>8);
            out.write(i);

            out.write(c>>8);
            out.write(c);

        }catch(IOException ex){
            System.err.println(ex.getMessage());
        }

        // Task 8.4
        try(FileInputStream in = new FileInputStream(file)) {
            byte1 = (byte) in.read();
            byte2 = (byte) in.read();
            byte3 = (byte) in.read();
            byte4 = (byte) in.read();

            System.out.println((int)((byte1 << 24) + (byte2 << 16) +(byte3<< 8) + byte4));

            byte5 = (byte) in.read();
            byte6 = (byte) in.read();
            System.out.println((char) ((byte1 << 8) + byte2));
            // Encoding: UTF-16BE

        }catch(IOException ex){
            System.err.println(ex.getMessage());
        }
    }
}
