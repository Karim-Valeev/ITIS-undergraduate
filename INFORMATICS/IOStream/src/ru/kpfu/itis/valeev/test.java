package ru.kpfu.itis.valeev;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class test {
    public static void main(String[] args) throws IOException {

        String str = "asdasdas = ,vdfvbsklvb";
        System.out.println(str.indexOf(" = "));

        try{
            Student s = new Student("Karim", LocalDate.parse("28.05.2001", DateTimeFormatter.ofPattern("dd.MM.yyyy")),"male","11-903");
            StudentJSONWriter out = new StudentJSONWriter(new FileOutputStream(new File("students.json")));
            out.writeStudent(s);
            StudentJSONReader in = new StudentJSONReader(new FileInputStream(new File("students.json")));
            System.out.println(in.readStudent() );
        } catch (IOException ex){
            ex.printStackTrace();
        }

        try{
            Student s = new Student("Bob", LocalDate.parse("23.01.1999", DateTimeFormatter.ofPattern("dd.MM.yyyy")),"male","11-703");
            StudentYAMLWriter out = new StudentYAMLWriter(new FileOutputStream(new File("students.yaml")));
            out.writeStudent(s);
            StudentYAMLReader in = new StudentYAMLReader(new FileInputStream(new File("students.yaml")));
            System.out.println(in.readStudent() );
        } catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
