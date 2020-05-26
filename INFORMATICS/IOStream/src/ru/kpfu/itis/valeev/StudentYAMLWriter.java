package ru.kpfu.itis.valeev;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StudentYAMLWriter extends OutputStream {

    private DataOutputStream out;

    public StudentYAMLWriter(OutputStream outputStream) {
        this.out = new DataOutputStream(outputStream);
    }

    public void writeStudent(Student student) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.writeValue((DataOutput) out, student);
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
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
