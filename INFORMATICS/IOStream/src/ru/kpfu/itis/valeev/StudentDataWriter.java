package ru.kpfu.itis.valeev;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.format.DateTimeFormatter;

public class StudentDataWriter extends DataOutputStream { // может только примитивы и стринги
    public StudentDataWriter(OutputStream out) {
        super(out);
    }

    public void writeStudent(Student s) {
        try{
            writeUTF(s.getName());
            writeUTF(s.getBirthDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            writeUTF(s.getGender());
            writeUTF(s.getGroup());
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}