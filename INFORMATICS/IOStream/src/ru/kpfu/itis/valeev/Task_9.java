package ru.kpfu.itis.valeev;

import java.io.*;
import java.nio.ByteBuffer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

public class Task_9<T> {
    private static final String path = "src/ru/kpfu/itis/valeev/stedents.txt";
    private static final int bytesPerStudent = 64;
    private static final ByteBuffer byteBuffer = ByteBuffer.allocateDirect(bytesPerStudent);

    public static void write(Collection<? extends Student> collection) throws IOException {
        File students = new File(path);
        try (FileOutputStream out = new FileOutputStream(students)) {
            for (Student s : collection) {
                putName(s);
                putDate(s);
                putGender(s);
                putGroup(s);
                byteBuffer.rewind();

                for (int i = 0; i < bytesPerStudent; i++) {
                    out.write(byteBuffer.get());
                }
                byteBuffer.rewind();
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static Collection<Student> read(File students) throws IOException {
        Collection<Student> data = new ArrayList<>();
        try(FileInputStream in = new FileInputStream(students)){
            boolean flag = true;
            while (flag){
                byte b;

                for (int i = 0; i < bytesPerStudent; i++) {
                    b = (byte) in.read();
                    if(b != -1) {
                        byteBuffer.put(b);
                    }else {
                        flag = false;
                        break;
                    }
                }
                byteBuffer.rewind();

                String name = getName();
                LocalDate birthDate = getBirthDate();
                String gender = getGender();
                String group = getGroup();
                Student s = new Student(name, birthDate, gender, group);
                data.add(s);
                byteBuffer.rewind();
            }
        } catch (IOException ex){
            System.err.println(ex.getMessage());
        }
        return data;
    }
    
    private static void putName(Student s) {
        for (int i = 0; i < 10; i++) {
            if (i < s.getName().length()) {
                byteBuffer.putChar(s.getName().charAt(i));
            } else {
                byteBuffer.putChar(Character.MIN_VALUE);
            }
        }
    }

    private static void putDate(Student s) {
        String date = s.getBirthDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        for (int i = 0; i < 10; i++) {
            byteBuffer.putChar(date.charAt(i));
        }
    }

    private static void putGender(Student s) {
        for (int i = 0; i < 6; i++) {
            if (i < s.getGender().length()) {
                byteBuffer.putChar(s.getGender().charAt(i));
            } else {
                byteBuffer.putChar(Character.MIN_VALUE);
            }
        }
    }

    private static void putGroup(Student s) {
        for (int i = 0; i < 6; i++) {
            byteBuffer.putChar(s.getGroup().charAt(i));
        }
    }

    private static String getName(){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i<10; i++){
            str.append(byteBuffer.getChar());
        }
        return str.toString();
    }

    private static LocalDate getBirthDate(){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i<10; i++){
            str.append(byteBuffer.getChar());
        }
        return LocalDate.parse(str,DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    private static String getGender(){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i<6; i++){
            str.append(byteBuffer.getChar());
        }
        return str.toString();
    }

    private static String getGroup(){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i<6; i++){
            str.append(byteBuffer.getChar());
        }
        return str.toString();
    }

    public static void main(String[] args) throws IOException {
        //LocalDate.parse("01.03.2002",DateTimeFormatter.ofPattern("dd.MM.yyyy"))
        ArrayList<Student> a = new ArrayList<>();
        a.add(new Student("Karim",LocalDate.parse("28.05.2001",DateTimeFormatter.ofPattern("dd.MM.yyyy")),"male","11-903"));
        a.add(new Student("Bob",LocalDate.parse("29.05.2001",DateTimeFormatter.ofPattern("dd.MM.yyyy")),"female","11-901"));
        a.add(new Student("Alexander",LocalDate.parse("01.03.2002",DateTimeFormatter.ofPattern("dd.MM.yyyy")),"male","11-905"));

        write(a);

        File b = new File(path);
        Object[] c = read(b).toArray();
        for(int i = 0; i < 3; i++){
            System.out.println(c[i].toString() + "\n");
        }
    }

}
