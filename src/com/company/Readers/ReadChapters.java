package com.company.Readers;

import com.company.Objects.Chapter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ReadChapters {
    private static ReadChapters reader;
    private static final String path = "src/com/company/Files/Chapters.csv";

    public ReadChapters() {
    }

    public static ReadChapters getReader() {
        if (reader == null)
            reader = new ReadChapters();
        return reader;
    }

    public void read(ArrayList<Chapter> chapters) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String item = bufferedReader.readLine();
            while ((item = bufferedReader.readLine()) != null) {
                String[] elements = item.split(",");
                chapters.add(new Chapter(elements[0], elements[1]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
