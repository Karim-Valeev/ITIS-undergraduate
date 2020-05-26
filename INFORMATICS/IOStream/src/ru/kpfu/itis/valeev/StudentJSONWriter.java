package ru.kpfu.itis.valeev;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StudentJSONWriter extends OutputStream {

    private DataOutputStream out;

    public StudentJSONWriter (OutputStream out) throws IOException {
        this.out = new DataOutputStream(out);
    }

    public void writeStudent(Student s) throws IOException {
        ObjectMapper om = new ObjectMapper();
        om.writeValue((DataOutput) out, s);
    }

    @Override
    public void write(int i) throws IOException {
        out.write(i);
    }

    @Override
    public void flush() throws IOException {
        out.flush();
    }

    @Override
    public void close() throws IOException {
        out.close();
    }
}
