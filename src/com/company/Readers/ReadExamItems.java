package com.company.Readers;

import com.company.Objects.ExamItem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadExamItems {
    private static ReadExamItems reader;
    private static final String path = "src/com/company/Files/ExamItems.csv";

    public ReadExamItems() {
    }

    public static ReadExamItems getReader() {
        if (reader == null)
            reader = new ReadExamItems();
        return reader;
    }

    public void read(ArrayList<ExamItem> examItems) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String item = bufferedReader.readLine();
            while ((item = bufferedReader.readLine()) != null) {
                String[] elements = item.split(",");
                examItems.add(new ExamItem(elements[0], elements[1], elements[2]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
