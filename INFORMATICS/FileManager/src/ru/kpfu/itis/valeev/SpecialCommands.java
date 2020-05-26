package ru.kpfu.itis.valeev;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SpecialCommands {

    public static void copy(File f, Path toPath) throws IOException {
        Files.copy(f.toPath(), toPath);
        if(f.isDirectory()) {
            for (File file : f.listFiles()) {
                copy(file, Paths.get(toPath.toString(), file.getName()));
            }
        }
    }

    public static void delete(File f){
        if(f.isDirectory()) {
            for (File file : f.listFiles()) {
                delete(file);
            }
        }
        f.delete();
    }
}
