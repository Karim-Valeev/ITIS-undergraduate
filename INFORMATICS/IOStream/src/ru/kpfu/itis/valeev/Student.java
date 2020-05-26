package ru.kpfu.itis.valeev;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Student implements Serializable{

    private String name;
    private LocalDate birthDate;
    private String gender;
    private String group;

    public Student(String name, LocalDate birthDate, String gender, String group) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public String getGroup() {
        return group;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setBirthDate(LocalDate date){this.birthDate = date;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(birthDate, student.birthDate) &&
                Objects.equals(gender, student.gender) &&
                Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate, gender, group);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", birthDate='" +  birthDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + '\'' +
                ", gender='" + gender + '\'' +
                ", group='" + group + '\'' +
                '}';
    }

    public static void main(String[] args) {

        Student s = new Student("a", LocalDate.parse("01.01.2001",DateTimeFormatter.ofPattern("dd.MM.yyyy")), "male", "11-903");
        System.out.println(s.toString());
    }

}