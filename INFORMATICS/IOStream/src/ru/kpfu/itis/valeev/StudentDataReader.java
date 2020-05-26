package ru.kpfu.itis.valeev;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentDataReader extends DataInputStream {
    public StudentDataReader(InputStream inputStream) {
        super(inputStream);
    }

    public Student readStudent(){
        try{
            return new Student(readUTF(), LocalDate.parse(readUTF(),DateTimeFormatter.ofPattern("dd.MM.yyyy")),readUTF(),readUTF());
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
