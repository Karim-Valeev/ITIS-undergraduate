package ru.kpfu.itis.valeev;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StudentJSONReader extends InputStream {

    private DataInputStream in;

    public StudentJSONReader(InputStream in) throws IOException {
        this.in = new DataInputStream(in);
    }

    public Student readStudent() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue((DataInput) in, Student.class);
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
