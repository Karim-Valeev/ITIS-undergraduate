package ru.kpfu.itis.valeev;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class StudentObjectReader extends ObjectInputStream {

    public StudentObjectReader(InputStream in) throws IOException {
        super(in);
    }

    public Student readStudent() {
        try{
            return (Student) readObject();
        } catch (IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return null;
    }



}
