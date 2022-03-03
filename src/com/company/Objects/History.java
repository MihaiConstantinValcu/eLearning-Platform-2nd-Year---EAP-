package com.company.Objects;

import com.company.Services.Audit;

import java.util.ArrayList;
import java.util.List;

public class History implements com.company.Services.History {
    private final List<Course> coursesTaken = new ArrayList<>();
    private final List<Integer> grades = new ArrayList<>();

    public History() {
    }

    @Override
    public void addCourse(Course course, int grade) {
        Audit.write("Add Course");
        coursesTaken.add(course);
        grades.add(grade);
    }

    @Override
    public void showHistory() {
        Audit.write("Show History");
        for (int i = 0; i < coursesTaken.size(); i++)
            System.out.println(coursesTaken.get(i).getName() + ": " + grades.get(i));
        System.out.println();
    }
}
