package com.company.Readers;

import com.company.Objects.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadStudents {
    private static ReadStudents reader;
    private static final String path = "src/com/company/Files/Students.csv";

    public ReadStudents() {
    }

    public static ReadStudents getReader() {
        if (reader == null)
            reader = new ReadStudents();
        return reader;
    }

    public void read(ArrayList<Student> students) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String item = bufferedReader.readLine();
            while ((item = bufferedReader.readLine()) != null) {
                String[] elements = item.split(",");
                students.add(new Student(elements[0], elements[1]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
