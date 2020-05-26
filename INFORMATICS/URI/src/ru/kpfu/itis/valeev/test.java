package ru.kpfu.itis.valeev;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {

        File f = new File("/URI/downloads");
//        System.out.println(f);
        File f2 = new File(f.getName() + "/UGA.txt");
        f2.createNewFile();

//        System.out.println("csdcs/svdsdv/vsdv/".replaceAll("/","_"));

        FileWriter fw = new FileWriter(f2);
        fw.write("Scdcsc");
        fw.close();

    }
}
