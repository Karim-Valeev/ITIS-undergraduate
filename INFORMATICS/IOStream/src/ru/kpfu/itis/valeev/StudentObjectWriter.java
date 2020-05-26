package ru.kpfu.itis.valeev;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class StudentObjectWriter extends ObjectOutputStream { // мжет что угодно

    public StudentObjectWriter(OutputStream out) throws IOException {
        super(out);
    }

    public void writeStudent(Student s){
        try{
            writeObject(s);
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
