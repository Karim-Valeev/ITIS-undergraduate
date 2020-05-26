package ru.kpfu.itis.valeev;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.regex.Matcher;

public class Test {

    public static void main(String[] args) throws IOException {
        File f = new File("/home/walai_kami/Desktop/cube.jpg");

        //copy /home/walai_kami/Desktop/Naruto to /home/walai_kami/Desktop/PeaceOfWood

        //FileSystem fs = new FileSystem();
        //Commands.CD.getCommand().execute("sd");

        //System.out.println(Arrays.toString(f.listFiles()));
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getName());
        System.out.println(f.toPath());
        System.out.println(f.toPath().normalize());
        System.out.println(f.exists());

        String[] cmd = {
                "xdg-open",
                f.getPath()
        };
        Process p = Runtime.getRuntime().exec(cmd);

//        cmd = new String[]{
//                "xdg-open",
//                f.getPath()
//        };
//        p = Runtime.getRuntime().exec(cmd);



    }

}
