package ru.kpfu.itis.valeev;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StudentYAMLReader extends InputStream{

    DataInputStream in;

    public StudentYAMLReader(InputStream in) {
        this.in = new DataInputStream(in);
    }

    public Student readStudent() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        Student s = objectMapper.readValue((DataInput) in, Student.class);
        return s;
    }

    @Override
    public int read() throws IOException {
        return in.read();
    }

    @Override
    public void close() throws IOException {
        in.close();
    }

}
