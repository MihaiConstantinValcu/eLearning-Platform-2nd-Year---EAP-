package com.company.Readers;

import com.company.Objects.Teacher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadTeachers {
    private static ReadTeachers reader;
    private static final String path = "src/com/company/Files/Teachers.csv";

    public ReadTeachers() {
    }

    public static ReadTeachers getReader() {
        if (reader == null)
            reader = new ReadTeachers();
        return reader;
    }

    public void read(ArrayList<Teacher> teachers) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String item = bufferedReader.readLine();
            while ((item = bufferedReader.readLine()) != null) {
                String[] elements = item.split(",");
                teachers.add(new Teacher(elements[0], elements[1]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
